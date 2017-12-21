package pe.edu.sistemas.sisrepweb.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.sistemas.sisrepweb.domain.HorarioClase;

@Repository
public interface HorarioClaseRepository extends JpaRepository<HorarioClase, Serializable>{
	
	@Query(value = "SELECT hc FROM HorarioClase hc "
			+ "WHERE hc.docente.persona.personaCodigo = :codigoDocente "
			+ "AND hc.grupo.cursoPeriodo.periodo.periodoNombre = :periodoNombre ")
	List<HorarioClase> obtenerHorarioCursos(@Param("codigoDocente") String codigoDocente, 
			@Param("periodoNombre") String periodoNombre);
}
