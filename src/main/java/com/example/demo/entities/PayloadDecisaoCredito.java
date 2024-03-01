package com.example.demo.entities;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.example.demo.helpers.PayloadTypeConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@Getter @Setter
@DynamoDBTable(tableName = "testtable")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayloadDecisaoCredito {
    @DynamoDBHashKey
    private String transacao;
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = PayloadTypeConverter.class)
    private PayloadIdentificacao identificacao;
    @DynamoDBAttribute
    private String payloadInput;
    @DynamoDBAttribute
    private String payloadOutput;
    @DynamoDBAttribute
    private String politicaDMP;
}
