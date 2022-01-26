package com.accenture.sirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Animale;


public interface AnimaleRepository extends JpaRepository<Animale, Long>{
	
	@Query("SELECT a.specie "
			+ "FROM Animale a "
			+ "WHERE a.specie = ?1 "
			+ "AND a.sesso = ?2 "
			+ "AND a.parcoNaturale = ?3")
	public String findSpecie(String specie, Character sesso, Long parco);
}
