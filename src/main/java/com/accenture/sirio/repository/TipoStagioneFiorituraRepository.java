package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.TipoStagioneFioritura;
import com.accenture.sirio.entityTO.TipoStagioneFiorituraTO;

public interface TipoStagioneFiorituraRepository extends JpaRepository<TipoStagioneFioritura, Long>{
	@Query("Select new com.accenture.sirio.entityTO.TipoStagioneFiorituraTO(s.id, s.descrizione) "
			+ "FROM TipoStagioneFioritura s ")
	public List<TipoStagioneFiorituraTO> findAllStagioni();
}
