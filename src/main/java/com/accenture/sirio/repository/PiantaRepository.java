package com.accenture.sirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Pianta;


public interface PiantaRepository extends JpaRepository<Pianta, Long>{
	
	@Query("SELECT p.specie "
			+ "FROM Pianta p "
			+ "WHERE p.specie = ?1 "
			+ "AND p.parcoNaturale = ?2")
	String findSpecie(String specie, Long parco);

}
