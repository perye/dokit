package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.dto.DeployQueryCriteria;
import com.perye.dokit.entity.Deploy;
import com.perye.dokit.entity.DeployHistory;
import com.perye.dokit.service.DeployService;
import com.perye.dokit.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author perye
 * @email peryedev@gmail.com
 * @date 2019/12/10 11:29 下午
 */
@Api(tags = "部署管理")
@RestController
@RequestMapping("/api/deploy")
public class DeployController {

    private String fileSavePath = System.getProperty("java.io.tmpdir");

    @Autowired
    private DeployService deployService;

    @Log("查询Deploy")
    @ApiOperation(value = "查询Deploy")
    @GetMapping
    @PreAuthorize("@dokit.check('deploy:list')")
    public ResponseEntity getDeploys(DeployQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(deployService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Deploy")
    @ApiOperation(value = "新增Deploy")
    @PostMapping
    @PreAuthorize("@dokit.check('deploy:add')")
    public ResponseEntity create(@Validated @RequestBody Deploy resources){
        return new ResponseEntity(deployService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Deploy")
    @ApiOperation(value = "修改Deploy")
    @PutMapping
    @PreAuthorize("@dokit.check('deploy:edit')")
    public ResponseEntity update(@Validated @RequestBody Deploy resources){
        deployService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Deploy")
    @ApiOperation(value = "删除Deploy")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("@dokit.check('deploy:del')")
    public ResponseEntity delete(@PathVariable String id){
        deployService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("上传文件Deploy")
    @ApiOperation(value = "上传文件Deploy")
    @PostMapping(value = "/upload")
    @PreAuthorize("@dokit.check('deploy:edit')")
    public ResponseEntity upload(@RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws Exception{
        String id = request.getParameter("id");
        String fileName = "";
        if(file != null){
            fileName = file.getOriginalFilename();
            File deployFile = new File(fileSavePath+fileName);
            FileUtil.del(deployFile);
            file.transferTo(deployFile);
            //文件下一步要根据文件名字来
            deployService.deploy(fileSavePath+fileName ,id);
        }else{
            System.out.println("没有找到相对应的文件");
        }
        System.out.println("文件上传的原名称为:"+file.getOriginalFilename());
        Map map = new HashMap(2);
        map.put("errno",0);
        map.put("id",fileName);
        return new ResponseEntity(map,HttpStatus.OK);
    }
    @Log("系统还原")
    @ApiOperation(value = "系统还原")
    @PostMapping(value = "/serverReduction")
    @PreAuthorize("@dokit.check('deploy:edit')")
    public ResponseEntity serverReduction(@Validated @RequestBody DeployHistory resources, HttpServletRequest request, HttpServletResponse response)throws Exception{
        String result = deployService.serverReduction(resources);
        return new ResponseEntity(result,HttpStatus.OK);
    }
    @Log("服务运行状态")
    @ApiOperation(value = "服务运行状态")
    @PostMapping(value = "/serverStatus")
    @PreAuthorize("@dokit.check('deploy:edit')")
    public ResponseEntity serverStatus(@Validated @RequestBody Deploy resources, HttpServletRequest request, HttpServletResponse response)throws Exception{
        String result = deployService.serverStatus(resources);
        return new ResponseEntity(result,HttpStatus.OK);
    }
    @Log("启动服务")
    @ApiOperation(value = "启动服务")
    @PostMapping(value = "/startServer")
    @PreAuthorize("@dokit.check('deploy:edit')")
    public ResponseEntity startServer(@Validated @RequestBody Deploy resources,  HttpServletRequest request, HttpServletResponse response)throws Exception{
        String result = deployService.startServer(resources);
        return new ResponseEntity(result,HttpStatus.OK);
    }
    @Log("停止服务")
    @ApiOperation(value = "停止服务")
    @PostMapping(value = "/stopServer")
    @PreAuthorize("@dokit.check('deploy:edit')")
    public ResponseEntity stopServer(@Validated @RequestBody Deploy resources,  HttpServletRequest request, HttpServletResponse response)throws Exception{
        String result = deployService.stopServer(resources);
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
