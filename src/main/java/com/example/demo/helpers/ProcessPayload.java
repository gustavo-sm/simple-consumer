package com.example.demo.helpers;

import com.example.demo.domain.IPayload;
import com.example.demo.domain.PayloadDecisaoCredito;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class ProcessPayload {
    public static void processPayload(String payload, IPayload p) throws JsonProcessingException {
        if (payload == null || payload.trim().isEmpty()) {
            System.out.println("Mensagem vazia");
            return;
        }
        TransformPayload tp = new TransformPayload(new PayloadDecisaoCredito());
        tp.parsePayload(payload);
    }
}
