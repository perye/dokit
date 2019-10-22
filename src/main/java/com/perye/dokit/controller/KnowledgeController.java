package com.perye.dokit.controller;

import com.perye.dokit.aop.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
@Slf4j
public class KnowledgeController {

    RestTemplate restTemplate = new RestTemplate();

    private String url = "https://api.ownthink.com/bot";

    @Log("查询知识图谱")
    @PostMapping(value = "/knowledge/search",produces = "application/json;charset=utf-8")
    public ResponseEntity search(@RequestBody String text) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("spoken", text);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        return new ResponseEntity(response.getBody(), HttpStatus.OK);
    }
}
