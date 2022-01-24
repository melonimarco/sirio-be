package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoStatoSalute;
import com.accenture.sirio.entityTO.TipoStatoSaluteTO;

public interface TipoStatoSaluteRepository extends JpaRepository<TipoStatoSalute, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoStatoSaluteTO(s.id, s.descrizione) "
			+ "FROM TipoStatoSalute s ")
	public List<TipoStatoSaluteTO> findAllStatiSalute();
	
	@Query("Select new com.accenture.sirio.entityTO.TipoStatoSaluteTO(s.id, s.descrizione) "
			+ "FROM TipoStatoSalute s "
			+ "WHERE s.id=?1")
	public TipoStatoSaluteTO findStatoSaluteById(Long id);
}
