package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.ParcoNaturale;
import com.accenture.sirio.entityRTO.XlsInfoParchiRTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;

public interface ParcoNaturaleRepository extends JpaRepository<ParcoNaturale, Long>  {
	
	@Query("Select new com.accenture.sirio.entityTO.ParcoNaturaleTO(p.id, p.nome) "
			+ "FROM ParcoNaturale p ")
	public List<ParcoNaturaleTO> findAllParchi();
	
	@Query("Select new com.accenture.sirio.entityTO.ParcoNaturaleTO(p.id, p.nome) "
			+ "FROM ParcoNaturale p "
			+ "WHERE p.id=?1")
	public ParcoNaturaleTO findParcoById(Long id);
	
	@Query("Select distinct new com.accenture.sirio.entityRTO.XlsInfoParchiRTO(pa.id, pa.nome, i.descrizione, a.specie) "
			+ "FROM ParcoNaturale pa, TipoEntitaInserimento i, Animale a "
			+ "WHERE a.parcoNaturale = pa.id "
			+ "AND i.id=2 ")
	public List<XlsInfoParchiRTO> findInfoParchiAnimaliXls();
	
	@Query("Select new com.accenture.sirio.entityRTO.XlsInfoParchiRTO(pa.id, pa.nome, i.descrizione, pi.specie) "
			+ "FROM ParcoNaturale pa, TipoEntitaInserimento i, Pianta pi "
			+ "WHERE pi.parcoNaturale = pa.id "
			+ "AND i.id=1 ")
	public List<XlsInfoParchiRTO> findInfoParchiPianteXls();

}
