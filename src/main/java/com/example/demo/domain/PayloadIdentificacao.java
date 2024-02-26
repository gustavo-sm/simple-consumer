package com.example.demo.domain;


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
// https://stackoverflow.com/questions/47262363/consider-marking-one-of-the-beans-as-primary