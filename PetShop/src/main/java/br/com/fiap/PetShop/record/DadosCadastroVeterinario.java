package br.com.fiap.PetShop.record;

import br.com.fiap.PetShop.model.Especialidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroVeterinario(
        @NotBlank
        String nome,

        @NotNull
        Long crv,

        @NotNull
        List<Especialidade>especialidades,

        @NotNull
        LocalDateTime diaAtivo
) {

}
