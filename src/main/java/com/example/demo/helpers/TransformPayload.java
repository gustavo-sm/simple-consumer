package com.example.demo.helpers;

import com.example.demo.domain.IPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class TransformPayload {
    private final IPayload p;
    public TransformPayload(IPayload p){
        this.p = p;
    }
    public void parsePayload(String payload) throws JsonParseException, JsonProcessingException {
        System.out.println("PAYLOAD CONSUMIDO "+payload);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(payload, this.p.getClass()));
    }
}
