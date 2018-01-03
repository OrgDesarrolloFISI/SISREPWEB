package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Serializable>{
	
	@Query("select d from Docente as d where d.persona.personaCodigo like ?1%")
	List<Docente> buscarDocentesPorCodigoParcial(String codigo);
	
	
	@Query("select d from Docente as d where d.persona.personaCodigo = ?1")
	Docente buscarDocentePorCodigo(String codigo);
}
