package br.com.fiap.PetShop.repository;

import br.com.fiap.PetShop.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
