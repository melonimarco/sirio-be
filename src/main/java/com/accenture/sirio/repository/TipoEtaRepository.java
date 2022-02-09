package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoEta;
import com.accenture.sirio.entityTO.TipoEtaTO;

public interface TipoEtaRepository extends JpaRepository<TipoEta, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoEtaTO(e.id, e.descrizione) "
			+ "FROM TipoEta e ")
	public List<TipoEtaTO> findAllEta();
}
