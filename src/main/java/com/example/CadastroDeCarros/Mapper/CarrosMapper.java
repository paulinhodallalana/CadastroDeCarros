package com.example.CadastroDeCarros.Mapper;


import com.example.CadastroDeCarros.DTO.CarrosDTO;
import com.example.CadastroDeCarros.Model.CarrosModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrosMapper {

    CarrosModel toEntity(CarrosDTO dto);

    CarrosDTO toDTO(CarrosModel model);


}
