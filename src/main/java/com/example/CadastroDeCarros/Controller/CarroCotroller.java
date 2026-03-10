package com.example.CadastroDeCarros.Controller;

import com.example.CadastroDeCarros.DTO.CarrosDTO;
import com.example.CadastroDeCarros.Model.CarrosModel;
import com.example.CadastroDeCarros.Service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/carros")
@RequiredArgsConstructor
public class CarroCotroller {

    private final CarroService carroService;

    //listar
    @GetMapping("/pagina-carros")
    public ResponseEntity<List<CarrosDTO>> listarCarros() {
        List<CarrosDTO> carro = carroService.listarCarros();
        return ResponseEntity.ok(carro);

    }

    //listar por id
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarCarroPorId(@PathVariable Long id) {
        CarrosDTO carro = carroService.listarCarroPorId(id);

        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com o id: " + id + ",Não encontrado");
        }

    }


    //criar carro
    @PostMapping("/criar")
    public ResponseEntity<String> criarCarro(@RequestBody CarrosDTO carrosDTO) {
        CarrosDTO carro = carroService.criarCarro(carrosDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Carro criado com sucesso " + carro.getMarca() + " (ID): " + carro.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> DeletarCarroPorId(@PathVariable Long id) {
        CarrosDTO carro = carroService.listarCarroPorId(id);

        if (carro != null) {
            carroService.deletarCarro(id);
            return ResponseEntity.ok("Carro de id:" + id + ",Deletado.");
        } else {
            return ResponseEntity.ok("Carro com id: " + id + ",Não encontrado");
        }


    }

    //alterar
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCarroPorId(@PathVariable Long id, @RequestBody CarrosDTO carrosDTO){
        if(carroService.atualiazarCarro(id,carrosDTO) != null){
            carroService.atualiazarCarro(id,carrosDTO);
            return ResponseEntity.ok("Carro com o id:" + id +",Atualizado com sucesso" );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carro com o id: " + id +",Não encontrado");
        }


    }









}


