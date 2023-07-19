package br.com.alura.jornadamilhas.repository;

import br.com.alura.jornadamilhas.model.Depoimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
}
