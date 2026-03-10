package com.example.CadastroDeCarros.Model;


import com.example.CadastroDeCarros.Enums.Status.Status;
import com.example.CadastroDeCarros.Enums.Status.TipoDeCombustivel.TipoDeCombustivel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_carros")
public class CarrosModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca",nullable = false)
    private String marca;

    @Column(name = "modelo",nullable = false)
    private String modelo;

    @Column(name = "ano",nullable = false)
    private int ano;

    @Column(name = "cor")
    private String cor;

    @Column(name = "placa",nullable = false)
    private String placa;

    @Column(name = "tipodecombustivel")
    @Enumerated(EnumType.STRING)
   private TipoDeCombustivel tipoDeCombustivel;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "preco",nullable = false)
    private double preco;

    @Column(name = "imagem")
    private String imagem;





}
