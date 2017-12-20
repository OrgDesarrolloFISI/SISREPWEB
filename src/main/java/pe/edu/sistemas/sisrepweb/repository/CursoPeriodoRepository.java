package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.sistemas.sisrepweb.domain.CursoPeriodo;
import pe.edu.sistemas.sisrepweb.domain.Grupo;

@Repository
@Transactional
public interface CursoPeriodoRepository extends JpaRepository<CursoPeriodo, Serializable>{
	
	@Query(value = "SELECT distinct hc.grupo.cursoPeriodo FROM HorarioClase hc "
			+ "WHERE hc.horarioClasePeriodo = :periodo "
			+ "AND hc.docente.iddocente = :idDocente "
			+ "AND hc.grupo.cursoPeriodo.cursoConjunto.cursoBase.plan.escuela.idescuela = :idEscuela")
	List<CursoPeriodo> obtenerCursosxDocenteyEscuela(@Param("periodo") String periodo,
			@Param("idDocente") Integer idDocente, @Param("idEscuela") Integer idEscuela);
}
