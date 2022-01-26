package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoOrdineAppartenenzaPianta;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO;


public interface TipoOrdineAppartenenzaPiantaRepository extends JpaRepository<TipoOrdineAppartenenzaPianta, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPiantaTO(o.id, o.descrizione) "
			+ "FROM TipoOrdineAppartenenzaPianta o ")
	public List<TipoOrdineAppartenenzaPiantaTO> findAllOrdiniAppPiante();
}
