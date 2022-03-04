package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.ParcoNaturale;
import com.accenture.sirio.entityRTO.ParcoNaturaleCompletoRTO;
import com.accenture.sirio.entityRTO.XlsInfoParchiRTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;
import com.accenture.sirio.entityTO.ParcoSalvataggioTO;

public interface ParcoNaturaleRepository extends JpaRepository<ParcoNaturale, Long>  {
	
	@Query("Select new com.accenture.sirio.entityRTO.ParcoNaturaleCompletoRTO(p.id, p.nome, p.regione, r.nome) "
			+ "FROM ParcoNaturale p, Regione r "
			+ "WHERE p.regione = r.id ")
	public List<ParcoNaturaleCompletoRTO> findAllParchiCompleti();
	
	@Query("Select new com.accenture.sirio.entityRTO.ParcoNaturaleCompletoRTO(p.id, p.nome, p.regione, r.nome) "
			+ "FROM ParcoNaturale p, Regione r "
			+ "WHERE p.regione = r.id "
			+ "AND p.id = ?1")
	public ParcoNaturaleCompletoRTO findParcoCompletoById(Long idParco);
	
	@Query("Select distinct new com.accenture.sirio.entityRTO.XlsInfoParchiRTO(pa.id, pa.nome, r.nome, i.descrizione, a.specie) "
			+ "FROM ParcoNaturale pa, Regione r, TipoEntitaInserimento i, Animale a "
			+ "WHERE pa.regione = r.id "
			+ "AND a.parcoNaturale = pa.id "
			+ "AND i.id=2 ")
	public List<XlsInfoParchiRTO> findInfoParchiAnimaliXls();
	
	@Query("Select new com.accenture.sirio.entityRTO.XlsInfoParchiRTO(pa.id, pa.nome, r.nome, i.descrizione, pi.specie) "
			+ "FROM ParcoNaturale pa, Regione r, TipoEntitaInserimento i, Pianta pi "
			+ "WHERE pa.regione = r.id "
			+ "AND pi.parcoNaturale = pa.id "
			+ "AND i.id=1 ")
	public List<XlsInfoParchiRTO> findInfoParchiPianteXls();
	
	@Query("Select p.nome "
			+ "FROM ParcoNaturale p "
			+ "WHERE p.nome=?1")
	public String findParcoByNome(String nomeParco);
	
	@Query("Select p.nome "
			+ "FROM ParcoNaturale p "
			+ "WHERE p.nome=?1 "
			+ "AND p.id <> ?2")
	public String findParcoByNomeEdit(String nomeParco, Long idParco);

	@Query("Select new com.accenture.sirio.entityTO.ParcoSalvataggioTO(pa.id, pa.nome, pa.regione) "
			+ "FROM ParcoNaturale pa "
			+ "WHERE  pa.id = ?1")
	public ParcoSalvataggioTO findDettaglioParcoPerEdit(Long idParco);
	
}
