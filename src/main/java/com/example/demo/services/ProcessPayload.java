package com.example.demo.services;

import com.example.demo.domain.PayloadDecisaoCredito;
import com.example.demo.domain.PayloadIdentificacao;
import com.example.demo.helpers.TransformPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class ProcessPayload {
    public static void processPayload(String payload)  {
        try {
            if (payload == null || payload.trim().isEmpty()) {
                System.out.println("Mensagem vazia");
                return;
            }
            TransformPayload transform = new TransformPayload();
            PayloadDecisaoCredito decisaoCredito = transform.parsePayload(payload);
            PayloadIdentificacao identificacao = decisaoCredito.getIdentificacao();
            System.out.println(decisaoCredito.getPayloadInput());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
