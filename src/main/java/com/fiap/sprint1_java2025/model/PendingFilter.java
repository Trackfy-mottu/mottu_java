package com.fiap.sprint1_java2025.model;

import com.fiap.sprint1_java2025.Enums.StatusPending;

public record PendingFilter(String description,
Long number, StatusPending status, String placaDaMoto) {

}
