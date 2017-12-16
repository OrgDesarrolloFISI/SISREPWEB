package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.CursoPeriodo;

@Repository
public interface CursoPeriodoRepository extends JpaRepository<CursoPeriodo, Serializable>{
	
	/*@Query("SELECT hc.grupo.cursoPeriodo FROM HorarioClase as hc "
			+ "WHERE hc.horarioClasePeriodo = ?1 "
			+ "AND hc.docente.iddocente = ?2"
			+ "AND hc.grupo.cursoPeriodo.cursoConjunto.cursoBase.plan.escuela.idescuela = ?3")
	List<CursoPeriodo> obtenerCursosxDocenteyEscuela(String periodo, String idDocente, String idEscuela);
	*/
}
