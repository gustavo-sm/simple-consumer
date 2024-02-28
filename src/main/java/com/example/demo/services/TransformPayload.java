package com.example.demo.services;

import com.example.demo.entities.PayloadDecisaoCredito;
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
                                    .replace("}\"", "}");

            HashMap<String, Object> map = mapper.readValue(escaped, HashMap.class);

            map.put("payloadInput", StringEscapeUtils.escapeJson(mapper.writeValueAsString(map.get("payloadInput"))));
            map.put("payloadOutput", StringEscapeUtils.escapeJson(mapper.writeValueAsString(map.get("payloadOutput"))));
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
