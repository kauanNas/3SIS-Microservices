package br.com.fiap.PetShop.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Veterinarios")
@Entity(name = "Veterinario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long crv;

    @ManyToMany
    private List<Especialidade> especialidades;

    private LocalDateTime diaAtivo;

    public Veterinario(String nome, Long crv, List<Especialidade> especialidades, LocalDateTime diaAtivo){
        this.nome = nome;
        this.crv = crv;
        this.especialidades = especialidades;
        this.diaAtivo = diaAtivo;
    }

}
