package com.example.demo.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.demo.database.DynamoDBConfig;
import com.example.demo.entities.PayloadDecisaoCredito;
import org.springframework.stereotype.Repository;

@Repository
public class PayloadRepository {
    final private DynamoDBMapper dynamoDBMapper;
    public PayloadRepository (DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }
    public String createRegistry(PayloadDecisaoCredito payloadDecisaoCredito){
        dynamoDBMapper.save(payloadDecisaoCredito);
        return payloadDecisaoCredito.getIdentificacao().getTransacao();
    }
}
