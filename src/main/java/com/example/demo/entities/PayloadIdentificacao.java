package com.example.demo.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
@Component
public class PayloadIdentificacao {
    private String transacao;
    private String pessoa;
    private String tipoPessoa;
    private String dataHoraExecucao;
}
