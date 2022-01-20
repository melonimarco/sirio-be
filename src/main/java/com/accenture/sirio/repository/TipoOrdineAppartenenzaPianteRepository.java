package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoOrdineAppartenenzaPiante;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPianteTO;


public interface TipoOrdineAppartenenzaPianteRepository extends JpaRepository<TipoOrdineAppartenenzaPiante, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoOrdineAppartenenzaPianteTO(o.id, o.descrizione) "
			+ "FROM TipoOrdineAppartenenzaPiante o ")
	public List<TipoOrdineAppartenenzaPianteTO> findAllOrdiniAppPiante();
}
