package com.perye.dokit.controller;

import com.perye.dokit.annotation.Log;
import com.perye.dokit.entity.EmailConfig;
import com.perye.dokit.service.EmailService;
import com.perye.dokit.vo.EmailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/email")
@RequiredArgsConstructor
@Api(tags = "工具：邮件管理")
public class EmailController {

    private final EmailService emailService;

    @GetMapping()
    public ResponseEntity<Object> queryConfig(){
        return new ResponseEntity<>(emailService.find(),HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping()
    @ApiOperation("配置邮件")
    public ResponseEntity<Object> updateConfig(@Validated @RequestBody EmailConfig emailConfig) throws Exception {
        emailService.config(emailConfig,emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping()
    @ApiOperation("发送邮件")
    public ResponseEntity<Object> sendEmail(@Validated @RequestBody EmailVo emailVo) {
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

