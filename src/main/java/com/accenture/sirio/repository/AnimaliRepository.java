package com.accenture.sirio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Animali;


public interface AnimaliRepository extends JpaRepository<Animali, Long>{
	
	@Query("SELECT a.specie "
			+ "FROM Animali a "
			+ "WHERE a.specie = ?1")
	public String findSpecie(String specie);
}
