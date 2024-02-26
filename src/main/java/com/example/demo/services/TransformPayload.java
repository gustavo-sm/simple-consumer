package com.example.demo.services;

import com.example.demo.domain.PayloadDecisaoCredito;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

@Component
public class TransformPayload {
    private final PayloadDecisaoCredito payloadObj;
    public TransformPayload(){
        this.payloadObj = new PayloadDecisaoCredito();
    }
    public PayloadDecisaoCredito parsePayload(String payload) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(payload, this.payloadObj.getClass());
        } catch (JsonParseException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
