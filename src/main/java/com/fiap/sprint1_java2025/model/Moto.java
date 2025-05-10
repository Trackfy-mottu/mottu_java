package com.fiap.sprint1_java2025.model;

import com.fiap.sprint1_java2025.Enums.LocalizacaoMoto;
import com.fiap.sprint1_java2025.Enums.ModeloMoto;
import com.fiap.sprint1_java2025.Enums.StatusMoto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Moto {
    @Id
    @NotNull(message = "O número do chassi da moto não pode ser nulo")
    private String placa;

    @NotNull(message = "O número do chassi da moto não pode ser nulo")
    private Long idChassi;

    @NotNull(message = "A localização da moto é obrigatória")
    private LocalizacaoMoto localização;

    @NotNull(message = "O status da moto é obrigatório")
    private StatusMoto status;

    private Pendencia pendencia;

    @NotNull(message = "O modelo da moto é obrigatório")
    private ModeloMoto modelo;

    @Size(max = 100, message = "O nome do pátio deve ter no máximo 100 caracteres")
    private String patio;

    @Min(value = 0, message = "A pendência deve ser no mínimo 0")
    private Long idUsuario;

}
