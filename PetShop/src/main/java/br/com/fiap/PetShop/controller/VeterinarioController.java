package br.com.fiap.PetShop.controller;

import br.com.fiap.PetShop.record.DadosCadastroVeterinario;
import br.com.fiap.PetShop.service.VeterinarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVeterinario dados, UriComponentsBuilder uriBuilder){
        var dto = service.cadastrarVeterinario(dados);
        var uri = uriBuilder.path("/veterinarios/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity listar(@PageableDefault Pageable paginacao){
        var dto = service.listarVeterinario(paginacao);
        return ResponseEntity.ok(dto);
    }

}
