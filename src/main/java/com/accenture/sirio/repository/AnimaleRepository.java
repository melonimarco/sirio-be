package com.accenture.sirio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accenture.sirio.entity.Animale;
import com.accenture.sirio.entityRTO.InfoAnimaleRTO;
import com.accenture.sirio.entityTO.AnimaleTO;
import com.accenture.sirio.entityTO.InfoCompleteAnimaleTO;


public interface AnimaleRepository extends JpaRepository<Animale, Long>{
	
	@Query("SELECT a.specie "
			+ "FROM Animale a "
			+ "WHERE a.specie = ?1 "
			+ "AND a.sesso = ?2 "
			+ "AND a.parcoNaturale = ?3")
	public String findSpecie(String specie, Character sesso, Long parco);
	
	@Query("SELECT a.specie "
			+ "FROM Animale a "
			+ "WHERE a.id <> ?1 "
			+ "AND a.specie = ?2 "
			+ "AND a.sesso = ?3 "
			+ "AND a.parcoNaturale = ?4")
	public String findSpecieEdit(Long idAnimale, String specie, Character sesso, Long parco);
	
	//Serve un RTO (RTO TO generato) (TO TO preso in input)
	@Query("Select new com.accenture.sirio.entityTO.AnimaleTO(a.id, a.specie, a.sesso, a.numeroEsemplari, a.tipoOrdineAppartenenzaAnimali, a.tipoStatoSalute, a.parcoNaturale) "
			+ "FROM Animale a "
			+ "WHERE a.parcoNaturale=?1 ")
	public List<AnimaleTO> findAnimaleByIdParco(Long id);
	
	@Query("Select new com.accenture.sirio.entityRTO.InfoAnimaleRTO(a.id, a.tipoOrdineAppartenenzaAnimali, a.specie, a.sesso, to.descrizione) "
			+ "FROM Animale a, TipoOrdineAppartenenzaAnimale to "
			+ "WHERE a.parcoNaturale=?1 "
			+ "AND to.id=a.tipoOrdineAppartenenzaAnimali")
	public List<InfoAnimaleRTO> findInfoAnimaleByIdParco(Long id);
	
	@Query("Select new com.accenture.sirio.entityTO.AnimaleTO(a.id, a.specie, a.sesso, a.numeroEsemplari, a.tipoOrdineAppartenenzaAnimali, a.tipoStatoSalute, a.parcoNaturale) "
			+ "FROM Animale a "
			+ "WHERE a.id=?1 ")
	public AnimaleTO findAnimaleById(Long id);
	
	@Query("Select new com.accenture.sirio.entityTO.InfoCompleteAnimaleTO(a.id, a.specie, a.sesso, a.numeroEsemplari, a.tipoOrdineAppartenenzaAnimali, a.tipoStatoSalute, a.parcoNaturale, to.descrizione, p.nome, s.descrizione) "
			+ "FROM Animale a, TipoOrdineAppartenenzaAnimale to, ParcoNaturale p, TipoStatoSalute s "
			+ "WHERE a.id=?1 "
			+ "AND to.id = a.tipoOrdineAppartenenzaAnimali "
			+ "AND p.id = a.parcoNaturale "
			+ "AND s.id = a.tipoStatoSalute")
	public InfoCompleteAnimaleTO findInfoCompleteAnimaleById(Long id);

	@Query("SELECT a.specie "
			+ "FROM Animale a "
			+ "WHERE a.id = ?1 "
			+ "AND a.parcoNaturale = ?2 ")
	public String findIfParcoChanged(Long idAnimale, Long parco);

}
