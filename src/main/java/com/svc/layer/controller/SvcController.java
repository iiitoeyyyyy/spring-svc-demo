package com.svc.layer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svc.layer.library.common.model.mb.ResponseModel;
import com.svc.layer.library.logger.AzureLoggerComponent;
import com.svc.layer.library.logger.SampleLogFormat;
import com.svc.layer.model.SvcModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SvcController {

    @Autowired
    HttpHeaders httpHeaders;

    @Autowired
    private AzureLoggerComponent azureLoggerComponent;

    @Autowired
    private ObjectMapper objMapper;

    @PostMapping("/svc/layer")
    public ResponseEntity<ResponseModel<SvcModel>> svcController(
            @RequestBody SvcModel svcModel
    ) throws JsonProcessingException {

        SampleLogFormat s = new SampleLogFormat("svc-layer", svcModel);
        azureLoggerComponent.pushLogsToAzure(objMapper.writeValueAsString(s));

        SvcModel response = new SvcModel(
                "Greeting connect svc microservice layer success!! " + svcModel.getName()
        );


        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders)
                .body(new ResponseModel<SvcModel>("1000","Success","Success")
                        .setDataObj(response));
    }
}
