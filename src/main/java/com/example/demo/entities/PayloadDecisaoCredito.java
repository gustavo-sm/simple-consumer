package com.example.demo.entities;


import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;

@Getter @Setter
@Component
public class PayloadDecisaoCredito {
    private PayloadIdentificacao identificacao;
    private String payloadInput;
    private String payloadOutput;
    private String politicaDMP;
}
