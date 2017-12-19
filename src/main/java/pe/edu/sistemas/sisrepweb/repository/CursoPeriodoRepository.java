package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisrepweb.domain.CursoPeriodo;

@Repository
@Transactional
public interface CursoPeriodoRepository extends JpaRepository<CursoPeriodo, Serializable>{
	
	@Query(value = "SELECT cp FROM HorarioClase hc, hc.grupo g, g.cursoPeriodo cp, cp.cursoConjunto cc, cc.cursoBase cb,"
			+ "cb.plan p, p.escuela e, hc.docente d "
			+ "WHERE hc.horarioClasePeriodo = :periodo "
			+ "AND d.iddocente = :idDocente")
	List<CursoPeriodo> obtenerCursosxDocenteyEscuela(@Param("periodo") String periodo,
			@Param("idDocente") Integer idDocente);
	
}
