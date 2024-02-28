package com.example.demo.services;

import com.example.demo.entities.PayloadDecisaoCredito;
import com.example.demo.entities.PayloadIdentificacao;
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
            System.out.println(decisaoCredito.getPayloadOutput());
            System.out.println(identificacao.getPessoa());
            System.out.println(identificacao.getDataHoraExecucao());
            System.out.println(decisaoCredito);

        } catch (Exception e){
            e.printStackTrace(); //Substituir por LOGGER
        }
    }

}
