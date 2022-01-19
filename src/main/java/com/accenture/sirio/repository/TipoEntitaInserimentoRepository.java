package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoEntitaInserimento;
import com.accenture.sirio.entityTO.TipoEntitaInserimentoTO;

public interface TipoEntitaInserimentoRepository extends JpaRepository<TipoEntitaInserimento, Long>{
	
	@Query("Select new com.accenture.sirio.entityTO.TipoEntitaInserimentoTO(e.id, e.descrizione) "
			+ "FROM TipoEntitaInserimento e ")
	public List<TipoEntitaInserimentoTO> findAllEntita();
}
