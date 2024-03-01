package com.example.demo.helpers;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.demo.entities.PayloadIdentificacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class PayloadTypeConverter implements  DynamoDBTypeConverter<Map<String, AttributeValue>, PayloadIdentificacao> {

    @Override
    public Map<String, AttributeValue> convert(PayloadIdentificacao payloadIdentificacao) {
        Item item = new Item()
                .withString("transacao", payloadIdentificacao.getTransacao())
                .withString("pessoa", payloadIdentificacao.getPessoa())
                .withString("tipoPessoa", payloadIdentificacao.getTipoPessoa())
                .withString("dataHoraExecucao", payloadIdentificacao.getDataHoraExecucao());

        return ItemUtils.toAttributeValues(item);
    }


    @Override
    public PayloadIdentificacao unconvert(Map<String, AttributeValue> data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String item = ItemUtils.toItem(data).toJSON();
            return mapper.readValue(item, PayloadIdentificacao.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}