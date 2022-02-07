package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Pianta;
import com.accenture.sirio.entityRTO.InfoCompletePiantaRTO;
import com.accenture.sirio.entityRTO.InfoPiantaRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.PiantaTO;


public interface PiantaRepository extends JpaRepository<Pianta, Long>{
	
	@Query("SELECT p.specie "
			+ "FROM Pianta p "
			+ "WHERE p.specie = ?1 "
			+ "AND p.parcoNaturale = ?2")
	String findSpecie(String specie, Long parco);
	
	@Query("Select new com.accenture.sirio.entityTO.PiantaTO(p.id, p.specie, p.tipoOrdineAppartenenzaPiante, p.tipoStagioneFioritura, p.parcoNaturale) "
			+ "FROM Pianta p "
			+ "WHERE p.parcoNaturale=?1")
	public List<PiantaTO> findPiantaByIdParco(Long id);
	
	@Query("Select new com.accenture.sirio.entityRTO.InfoPiantaRTO(p.id, p.specie, p.tipoOrdineAppartenenzaPiante, to.descrizione) "
			+ "FROM Pianta p, TipoOrdineAppartenenzaPianta to "
			+ "WHERE p.parcoNaturale=?1 "
			+ "AND to.id=p.tipoOrdineAppartenenzaPiante")
	public List<InfoPiantaRTO> findInfoPiantaByIdParco(Long id);
	
	@Query("Select new com.accenture.sirio.entityTO.PiantaTO(p.id, p.specie, p.tipoOrdineAppartenenzaPiante, p.tipoStagioneFioritura, p.parcoNaturale) "
			+ "FROM Pianta p "
			+ "WHERE p.id=?1")
	public PiantaTO findPiantaById(Long id);
	
	@Query("Select new com.accenture.sirio.entityRTO.InfoCompletePiantaRTO(p.id, p.specie, p.tipoOrdineAppartenenzaPiante, p.tipoStagioneFioritura, p.parcoNaturale, to.descrizione, ss.descrizione, pn.nome) "
			+ "FROM Pianta p, TipoOrdineAppartenenzaPianta to, TipoStagioneFioritura ss, ParcoNaturale pn "
			+ "WHERE p.id = ?1 "
			+ "AND to.id = p.tipoOrdineAppartenenzaPiante "
			+ "AND ss.id = p.tipoStagioneFioritura "
			+ "AND pn.id = p.parcoNaturale ")
	public InfoCompletePiantaRTO findInfoCompletePiantaById(Long id);

	
	@Query("SELECT p.specie "
			+ "FROM Pianta p "
			+ "WHERE p.id <> ?1 "
			+ "AND p.specie = ?2 "
			+ "AND p.parcoNaturale = ?3")
	public String findSpecieEdit(Long idPianta, String specie, Long parco);

}
