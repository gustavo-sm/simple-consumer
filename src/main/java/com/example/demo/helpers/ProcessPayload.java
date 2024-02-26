package com.example.demo.helpers;

import com.example.demo.domain.PayloadDecisaoCredito;
import com.example.demo.domain.PayloadIdentificacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class ProcessPayload {
    public static void processPayload(String payload) throws JsonProcessingException {
        if (payload == null || payload.trim().isEmpty()) {
            System.out.println("Mensagem vazia");
            return;
        }
        TransformPayload transform = new TransformPayload();
        PayloadDecisaoCredito decisaoCredito = transform.parsePayload(payload);
        PayloadIdentificacao identificacao = decisaoCredito.getIdentificacao();

    }
}
