package com.example.demo.services;

import com.example.demo.database.DynamoDBConfig;
import com.example.demo.entities.PayloadDecisaoCredito;
import com.example.demo.entities.PayloadIdentificacao;
import com.example.demo.repositories.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProcessPayload {
    @Autowired
    private DynamoDBConfig dynamoDBConfig;
    public void processPayload(String payload)  {
        try {
            if (payload == null || payload.trim().isEmpty()) {
                System.out.println("Mensagem vazia");
                return;
            }
            TransformPayload transform = new TransformPayload();
            PayloadDecisaoCredito decisaoCredito = transform.parsePayload(payload);
            PayloadRepository payloadRepository = new PayloadRepository(dynamoDBConfig.dynamoDBMapper());
            payloadRepository.createRegistry(decisaoCredito);

        } catch (Exception e){
            e.printStackTrace(); //Substituir por LOGGER
        }
    }

}
