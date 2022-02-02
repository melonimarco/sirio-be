package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.ParcoNaturaleTO;


public interface AnimaleRepository extends JpaRepository<Animale, Long>{
	
	@Query("SELECT a.specie "
			+ "FROM Animale a "
			+ "WHERE a.specie = ?1 "
			+ "AND a.sesso = ?2 "
			+ "AND a.parcoNaturale = ?3")
	public String findSpecie(String specie, Character sesso, Long parco);
	
	@Query("Select new com.accenture.sirio.entityTO.AnimaleTO(a.id, a.specie, a.sesso, a.numeroEsemplari, a.tipoOrdineAppartenenzaAnimali, a.tipoStatoSalute, a.parcoNaturale) "
			+ "FROM Animale a "
			+ "WHERE a.parcoNaturale=?1 ")
	public List<AnimaleTO> findAnimaleByIdParco(Long id);
}
