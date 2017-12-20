package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Serializable>{
	
	@Query(value = "SELECT distinct hc.grupo FROM HorarioClase hc "
			+ "WHERE hc.horarioClasePeriodo = :periodo "
			+ "AND hc.docente.iddocente = :idDocente "
			+ "AND hc.grupo.cursoPeriodo.cursoConjunto.cursoBase.plan.escuela.idescuela = :idEscuela")
	List<Grupo> obtenerGruposxDocenteyEscuela(@Param("periodo") String periodo,
			@Param("idDocente") Integer idDocente, @Param("idEscuela") Integer idEscuela);
}
