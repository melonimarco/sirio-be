package com.accenture.sirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Piante;


public interface PianteRepository extends JpaRepository<Piante, Long>{
	
	@Query("SELECT p.specie "
			+ "FROM Piante p "
			+ "WHERE p.specie = ?1")
	String findSpecie(String specie);

}
