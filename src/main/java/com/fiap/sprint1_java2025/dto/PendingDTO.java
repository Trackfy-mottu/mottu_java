package com.fiap.sprint1_java2025.dto;

import com.fiap.sprint1_java2025.Enums.StatusPending;

public record PendingDTO(
        Long id,
        Long number,
        String descricao,
        StatusPending status,
        String placaMoto) {
}
