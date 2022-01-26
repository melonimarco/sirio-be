package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoOrdineAppartenenzaAnimale;
import com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO;

public interface TipoOrdineAppartenenzaAnimaleRepository extends JpaRepository<TipoOrdineAppartenenzaAnimale, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO(o.id, o.descrizione) "
			+ "FROM TipoOrdineAppartenenzaAnimale o ")
	public List<TipoOrdineAppartenenzaAnimaleTO> findAllOrdiniAppAnimali();
	
	@Query("Select new com.accenture.sirio.entityTO.TipoOrdineAppartenenzaAnimaleTO(o.id, o.descrizione) "
			+ "FROM TipoOrdineAppartenenzaAnimale o "
			+ "WHERE o.id=?1")
	public TipoOrdineAppartenenzaAnimaleTO findOrdineAppAnimaliById(Long id);
}
