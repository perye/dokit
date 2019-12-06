package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.PictureQueryCriteria;
import com.perye.dokit.entity.Picture;
import com.perye.dokit.service.PictureService;
import com.perye.dokit.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pictures")
@Api(tags = "免费图床管理")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @Log("查询图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_SELECT')")
    @GetMapping()
    @ApiOperation(value = "查询图片")
    public ResponseEntity getRoles(PictureQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(pictureService.queryAll(criteria,pageable), HttpStatus.OK);
    }

    @Log("上传图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_UPLOAD')")
    @PostMapping
    @ApiOperation(value = "上传图片")
    public ResponseEntity upload(@RequestParam MultipartFile file){
        String userName = SecurityUtils.getUsername();
        Picture picture = pictureService.upload(file,userName);
        Map<String,Object> map = new HashMap<>(3);
        map.put("errno",0);
        map.put("id",picture.getId());
        map.put("data",new String[]{picture.getUrl()});
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @Log("删除图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_DELETE')")
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除图片")
    public ResponseEntity delete(@PathVariable Long id) {
        pictureService.delete(pictureService.findById(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("多选删除图片")
    @ApiOperation(value = "多选删除图片")
    @PreAuthorize("hasAnyRole('ADMIN','PICTURE_ALL','PICTURE_DELETE')")
    @DeleteMapping
    public ResponseEntity deleteAll(@RequestBody Long[] ids) {
        pictureService.deleteAll(ids);
        return new ResponseEntity(HttpStatus.OK);
    }
}

