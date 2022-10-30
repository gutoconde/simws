package com.gutoconde.simws.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gutoconde.simws.model.entity.Servidor;

@Repository
public interface RepositorioServidor extends CrudRepository<Servidor, Integer>{
	
	@Query("SELECT s FROM Servidor s WHERE s.lotacao.codigo = :codigoLotacao")
	List<Servidor> listarServidoresPeloCodigoDaLotacao(String codigoLotacao);
}
