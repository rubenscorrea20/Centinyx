package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import centinyx.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	
	List<Perfil> findByTipoAcesso(String tipoAcesso);

	@Query("SELECT p FROM Perfil p WHERE p.tipoAcesso = :tipoAcesso")
	public Perfil encontraId(@Param("tipoAcesso") String tipoAcesso);
}
