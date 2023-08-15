package br.com.alura.jornadamilhas.repository;

import br.com.alura.jornadamilhas.model.Depoimento;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepoimentoRepository extends MongoRepository<Depoimento, String> {
    @Aggregation(pipeline = { "{ $sample: { size: ?0 } }",
            "{ $project: { 'foto' : 1, 'depoimento' : 1, 'cliente' : 1 } }" })
    List<Depoimento> findRandomDepoimentos(int quantidade);
}
