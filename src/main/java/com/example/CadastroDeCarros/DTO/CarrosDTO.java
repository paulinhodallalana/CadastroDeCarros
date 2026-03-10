package com.example.CadastroDeCarros.DTO;

import com.example.CadastroDeCarros.Enums.Status.Status;
import com.example.CadastroDeCarros.Enums.Status.TipoDeCombustivel.TipoDeCombustivel;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarrosDTO {

    private Long id; // opcional para requisições de criação

    @NotBlank(message = "Marca é obrigatória")
    private String marca;

    @NotBlank(message = "Modelo é obrigatório")
    private String modelo;

    @NotNull(message = "Ano é obrigatório")
    @Min(value = 1886, message = "Ano deve ser maior ou igual a 1886")
    private Integer ano;

    @NotBlank(message = "Cor é obrigatória")
    private String cor;

    @NotBlank(message = "Placa é obrigatória")
    @Size(min = 7, max = 8, message = "Placa deve ter entre 7 e 8 caracteres")
    private String placa;

    @NotNull(message = "Tipo de combustível é obrigatório")
    private TipoDeCombustivel tipoDeCombustivel;

    @NotNull(message = "Status é obrigatório")
    private Status status;



    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double preco;

    private String imagem;

}