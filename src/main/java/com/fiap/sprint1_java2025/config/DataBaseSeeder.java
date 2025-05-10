package com.fiap.sprint1_java2025.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fiap.sprint1_java2025.Enums.LocalizacaoMoto;
import com.fiap.sprint1_java2025.Enums.ModeloMoto;
import com.fiap.sprint1_java2025.Enums.StatusMoto;
import com.fiap.sprint1_java2025.Enums.StatusPendencia;
import com.fiap.sprint1_java2025.model.Moto;
import com.fiap.sprint1_java2025.model.Pendencia;
import com.fiap.sprint1_java2025.repository.MotoRepository;
import com.fiap.sprint1_java2025.repository.PendenciaRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataBaseSeeder {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PendenciaRepository pendenciaRepository;

    @PostConstruct
    public void init() {
        Moto moto1 = Moto.builder()
                .placa("ABC1234")
                .idChassi(1001L)
                .localização(LocalizacaoMoto.DENTRO)
                .status(StatusMoto.EmUso)
                .modelo(ModeloMoto.Sport)
                .patio("Pátio Central")
                .idUsuario(1L)
                .build();

        Moto moto2 = Moto.builder()
                .placa("XYZ5678")
                .idChassi(1002L)
                .localização(LocalizacaoMoto.DENTRO)
                .status(StatusMoto.EmUso)
                .modelo(ModeloMoto.E)
                .patio("Pátio Leste")
                .build();

        Moto moto3 = Moto.builder()
                .placa("GHJ9101")
                .idChassi(0321L)
                .localização(LocalizacaoMoto.FORA)
                .status(StatusMoto.EmUso)
                .modelo(ModeloMoto.Pop)
                .build();
        motoRepository.saveAll(Arrays.asList(moto1, moto2, moto3));

        Pendencia pend1 = Pendencia.builder()
                .number(1L)
                .descricao("Falta de documentação")
                .status(StatusPendencia.EmAndamento)
                .moto(moto1)
                .build();

        Pendencia pend2 = Pendencia.builder()
                .number(2L)
                .descricao("Multa em aberto")
                .status(StatusPendencia.Pendente)
                .moto(moto2)
                .build();

        pendenciaRepository.saveAll(Arrays.asList(pend1, pend2));
    }
}
