package br.com.fiap.PetShop.service;

import br.com.fiap.PetShop.model.Veterinario;
import br.com.fiap.PetShop.record.DadosCadastroVeterinario;
import br.com.fiap.PetShop.record.DadosDetalhamentoVeterinario;
import br.com.fiap.PetShop.record.DadosListagemVeterinario;
import br.com.fiap.PetShop.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VeterinarioService {

    @Autowired
    VeterinarioRepository repository;
    public DadosDetalhamentoVeterinario cadastrarVeterinario(DadosCadastroVeterinario dados) {
        var veterinario = new Veterinario(dados.nome(), dados.crv(), dados.especialidades(), dados.diaAtivo());
        repository.save(veterinario);
        return new DadosDetalhamentoVeterinario(veterinario);
    }

    public Page<DadosListagemVeterinario> listarVeterinario(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemVeterinario::new);
        return page;
    }
}
