package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.ParcoNaturale;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;

public interface ParcoNaturaleRepository extends JpaRepository<ParcoNaturale, Long>  {
	
	@Query("Select new com.accenture.sirio.entityTO.ParcoNaturaleTO(p.id, p.nome) "
			+ "FROM ParcoNaturale p ")
	public List<ParcoNaturaleTO> findAllParchi();
}
