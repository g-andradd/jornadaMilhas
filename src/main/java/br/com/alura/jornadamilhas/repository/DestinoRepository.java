package br.com.alura.jornadamilhas.repository;

import br.com.alura.jornadamilhas.model.Destino;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DestinoRepository extends MongoRepository<Destino, String> {

    List<Destino> findByNome(String nome);

}
