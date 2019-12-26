package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.entity.Captcha;
import com.perye.dokit.service.CaptchaService;
import com.perye.dokit.query.CaptchaQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Api(tags = "captcha管理")
@RestController
@RequestMapping("/api/captcha")
public class CaptchaController {

    private final CaptchaService captchaService;

    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@dokit.check('captcha:list')")
    public void download(HttpServletResponse response, CaptchaQueryCriteria criteria) throws IOException {
        captchaService.download(captchaService.queryAll(criteria), response);
    }

    @Log("查询captcha")
    @ApiOperation("查询captcha")
    @GetMapping()
    @PreAuthorize("@dokit.check('captcha:list')")
    public ResponseEntity<Object> getCaptchas(CaptchaQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(captchaService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增captcha")
    @ApiOperation("新增captcha")
    @PostMapping
    @PreAuthorize("@dokit.check('captcha:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Captcha resources){
        return new ResponseEntity<>(captchaService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改captcha")
    @ApiOperation("修改captcha")
    @PutMapping
    @PreAuthorize("@dokit.check('captcha:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Captcha resources){
    captchaService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除captcha")
    @ApiOperation("删除captcha")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('captcha:del')")
    public ResponseEntity<Object> delete(@PathVariable Long id){
    captchaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Log("多选删除captcha")
    @ApiOperation("多选删除captcha")
    @PreAuthorize("@dokit.check('captcha:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
    captchaService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
