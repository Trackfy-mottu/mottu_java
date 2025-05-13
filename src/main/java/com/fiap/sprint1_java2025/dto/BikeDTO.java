package com.fiap.sprint1_java2025.dto;

import java.util.List;

import com.fiap.sprint1_java2025.Enums.LocationBike;
import com.fiap.sprint1_java2025.Enums.ModelsBike;
import com.fiap.sprint1_java2025.Enums.StatusBike;

public record BikeDTO(
        String placa,
        StatusBike status,
        List<PendingDTO> pendencias,
        ModelsBike modelo,
        LocationBike localizacao) {

}
