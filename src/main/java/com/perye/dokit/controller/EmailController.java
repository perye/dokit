package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import com.perye.dokit.entity.EmailConfig;
import com.perye.dokit.service.EmailService;
import com.perye.dokit.vo.EmailVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/email")
@Api(tags = "邮件管理")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping()
    public ResponseEntity get(){
        return new ResponseEntity<>(emailService.find(),HttpStatus.OK);
    }

    @Log("配置邮件")
    @PutMapping()
    @ApiOperation(value = "配置邮件")
    public ResponseEntity emailConfig(@Validated @RequestBody EmailConfig emailConfig){
        emailService.update(emailConfig,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }

    @Log("发送邮件")
    @PostMapping()
    @ApiOperation(value = "发送邮件")
    public ResponseEntity send(@Validated @RequestBody EmailVo emailVo) throws Exception {
        emailService.send(emailVo,emailService.find());
        return new ResponseEntity(HttpStatus.OK);
    }
}

