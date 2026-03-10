package com.example.CadastroDeCarros.Controller;

import com.example.CadastroDeCarros.DTO.CarrosDTO;
import com.example.CadastroDeCarros.Service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui/carros")
@RequiredArgsConstructor
public class CarroControllerUi {

    private final CarroService carroService;

    // abrir página que lista carros
    @GetMapping
    public String listarCarros(Model model){

        model.addAttribute("carros", carroService.listarCarros());

        return "carros"; // carros.html
    }

    // abrir página de criar carro
    @GetMapping("/adicionar")
    public String paginaCriarCarro(){
        return "criar-carro"; // criar-carro.html
    }

    // deletar carro pelo botão da página
    @PostMapping("/deletar/{id}")
    public String deletarCarro(@PathVariable Long id){

        carroService.deletarCarro(id);

        return "redirect:/ui/carros";
    }

    // abrir página de edição de carro
    @GetMapping("/editar/{id}")
    public String paginaEditarCarro(@PathVariable Long id, Model model){
        model.addAttribute("carro", carroService.listarCarroPorId(id));
        return "editar-carro"; // editar-carro.html
    }

    // enviar formulário de atualização
    @PostMapping("/alterar/{id}")
    public String alterarCarro(@PathVariable Long id, CarrosDTO carrosDTO){
        carroService.atualiazarCarro(id,carrosDTO);
        return "redirect:/ui/carros"; // volta pra página de listagem
    }

    // enviar formulário de criação
    @PostMapping("/criar")
    public String criarCarroUi(CarrosDTO carrosDTO){
        carroService.criarCarro(carrosDTO);
        return "redirect:/ui/carros"; // volta pra página de listagem
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesCarro(@PathVariable Long id, Model model){

        model.addAttribute("carro", carroService.listarCarroPorId(id));

        return "detalhes"; // detalhes.html
    }

}