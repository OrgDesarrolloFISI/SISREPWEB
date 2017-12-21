package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.Asistencia;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Serializable>{
	/*
	@Query(value = "SELECT a FROM Asistencia a "
			+ "WHERE a.horarioClase.docente.iddocente = :idDocente "
			+ "AND a.horarioClase.grupo.cursoPeriodo.periodo.periodoNombre = :periodoNombre "
			+ "AND a.asistenciaFecha BETWEEN :inicio AND :fin")
	List<Asistencia> obtenerAsistenciasxDocenteyPeriodo(@Param("idDocente") Integer idDocente, 
			@Param("periodoNombre") String periodoNombre, @Param("inicio") Date inicio, @Param("fin") Date fin );
	*/
	
	@Query(value = "SELECT a FROM Asistencia a "
			+ "WHERE a.horarioClase.idhorarioClase = :idHorarioClase "
			+ "AND a.asistenciaFecha BETWEEN :inicio AND :fin")
	List<Asistencia> obtenerAsistenciasxHorarioClaseEIntervalo(@Param("idHorarioClase") Integer idHorarioClase, 
			@Param("inicio") Date inicio, @Param("fin") Date fin );
	
	@Query(value = "SELECT a FROM Asistencia a "
			+ "WHERE a.horarioClase.idhorarioClase = :idHorarioClase ")
	List<Asistencia> obtenerAsistenciasxHorarioClase(@Param("idHorarioClase") Integer idHorarioClase );
}
	
