package br.com.fiap.PetShop.record;

import br.com.fiap.PetShop.model.Especialidade;
import br.com.fiap.PetShop.model.Veterinario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemVeterinario(Long id, String nome, Long crv, List<Especialidade> especialidades, LocalDateTime diaAtivo) {
    public DadosListagemVeterinario(Veterinario veterinario) {
        this(veterinario.getId(), veterinario.getNome(), veterinario.getCrv(), veterinario.getEspecialidades(), veterinario.getDiaAtivo());
    }
}
