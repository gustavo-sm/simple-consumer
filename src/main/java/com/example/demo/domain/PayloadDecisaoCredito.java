package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import com.example.demo.domain.IPayload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
public class PayloadDecisaoCredito implements IPayload {
    private Map<String, String> identificacao;
    private String PayloadInput;
    private String PayloadOutput;
    private String PoliticaDMP;
}