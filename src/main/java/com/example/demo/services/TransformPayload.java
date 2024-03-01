package com.example.demo.services;

import com.example.demo.entities.PayloadDecisaoCredito;
import com.example.demo.entities.PayloadIdentificacao;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TransformPayload {
    private final PayloadDecisaoCredito payloadObj;
    public TransformPayload(){
        this.payloadObj = new PayloadDecisaoCredito();
    }
    public PayloadDecisaoCredito parsePayload(String payload) { //refatorar metodo, ver onde faz sentido colocar pois tem muita coisa em 1 func só
        try {

            ObjectMapper mapper = new ObjectMapper();
            payload = payload
                        .replace("\n","")
                            .replace("\t","");

            String escaped = payload
                                .replace("\"{", "{")
                                    .replace("}\"", "}")
                                        .replace("\"[","[")
                                            .replace("]\"","]");


            HashMap<String, Object> map = mapper.readValue(escaped, HashMap.class);
            PayloadIdentificacao identificacao = mapper.readValue(mapper.writeValueAsString(map.get("identificacao")), PayloadIdentificacao.class);
            map.put("transacao", identificacao.getTransacao());
            map.put("payloadInput", mapper.writeValueAsString(map.get("payloadInput")));
            map.put("payloadOutput", mapper.writeValueAsString(map.get("payloadOutput")));
            map.put("politicaDMP", mapper.writeValueAsString(map.get("politicaDMP")));

            return mapper.readValue(mapper.writeValueAsString(map), PayloadDecisaoCredito.class);

        } catch (JsonParseException | JsonProcessingException  e) {
            e.printStackTrace();
            return null;
        }
    }

    public String stringifyPayload(PayloadDecisaoCredito payload) throws JsonProcessingException, NullPointerException{
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(payload);
        return jsonString;
    }
}
