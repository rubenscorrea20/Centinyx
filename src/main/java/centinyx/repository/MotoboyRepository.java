package centinyx.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import centinyx.model.Motoboy;

public interface MotoboyRepository extends JpaRepository<Motoboy, Integer>  {

	Page<Motoboy> findByFuncionarioNomeContaining(String nome, Pageable p);
	
	@Query("SELECT m FROM Motoboy m WHERE m.idMotoboy = :idMotoboy")
	public List<Motoboy> encontraMotoboysAlocados(@Param("idMotoboy") int idMotoboy);
}