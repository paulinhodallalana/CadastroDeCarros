package com.example.CadastroDeCarros.Repository;

import com.example.CadastroDeCarros.DTO.CarrosDTO;
import com.example.CadastroDeCarros.Model.CarrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepository extends JpaRepository<CarrosModel, Long> {

}
