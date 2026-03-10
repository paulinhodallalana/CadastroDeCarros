package com.example.CadastroDeCarros.Service;


import com.example.CadastroDeCarros.DTO.CarrosDTO;
import com.example.CadastroDeCarros.Mapper.CarrosMapper;
import com.example.CadastroDeCarros.Model.CarrosModel;
import com.example.CadastroDeCarros.Repository.CarrosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarrosRepository carrosRepository;
    private final CarrosMapper carrosMapper;



    //listar carros

    public List<CarrosDTO> listarCarros(){
        List<CarrosModel> carros = carrosRepository.findAll();
      return carros.stream()
              .map(carrosMapper::toDTO)
              .toList();

    };

    //listarPor id
    public CarrosDTO listarCarroPorId(Long id ){
        Optional<CarrosModel> carroPorId = carrosRepository.findById(id);
        return carroPorId.map(carrosMapper::toDTO)
                .orElse(null);


    };

    //criar novo carro
    public CarrosDTO criarCarro(CarrosDTO carro){
        CarrosModel novoCarro = carrosMapper.toEntity(carro);
        CarrosModel carroAtualizado = carrosRepository.save(novoCarro);
         return  carrosMapper.toDTO(carroAtualizado);


    };

    public void deletarCarro(Long id ) {
        carrosRepository.deleteById(id);
    }

    //AtualizarCarroPorId
    public CarrosDTO atualiazarCarro(Long id , CarrosDTO carrosDTO){
        Optional<CarrosModel> carroExistente = carrosRepository.findById(id);
        if(carroExistente.isPresent()){
            CarrosModel carroAtualizado = carrosMapper.toEntity(carrosDTO);
            carroAtualizado.setId(id);
            CarrosModel carroSalvo = carrosRepository.save(carroAtualizado);

            return carrosMapper.toDTO(carroSalvo);
        }
            return null;



    };





}
