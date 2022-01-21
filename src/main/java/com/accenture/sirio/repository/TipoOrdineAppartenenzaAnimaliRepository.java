package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoOrdineAppartenenzaAnimali;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaliTO;

public interface TipoOrdineAppartenenzaAnimaliRepository extends JpaRepository<TipoOrdineAppartenenzaAnimali, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaliTO(o.id, o.descrizione) "
			+ "FROM TipoOrdineAppartenenzaAnimali o ")
	public List<TipoOrdineAppartenenzaAnimaliTO> findAllOrdiniAppAnimali();
}
