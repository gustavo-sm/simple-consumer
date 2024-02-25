package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import com.example.demo.domain.IPayload;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
public class PayloadIdentificacao implements IPayload {
    private String transacao;
    private String pessoa;
    private String tipoPessoa;
    private String dataHoraExecucao;
}
// https://stackoverflow.com/questions/47262363/consider-marking-one-of-the-beans-as-primary