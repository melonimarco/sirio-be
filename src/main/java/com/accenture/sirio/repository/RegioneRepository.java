package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Regione;
import com.accenture.sirio.entityTO.ListRegioniTO;
import com.accenture.sirio.entityTO.RegioneTO;

public interface RegioneRepository extends JpaRepository<Regione, Long>  {

	@Query("Select new com.accenture.sirio.entityTO.RegioneTO(r.id, r.nome) "
			+ "FROM Regione r ")
	List<RegioneTO> findAllRegioni();
	
}
