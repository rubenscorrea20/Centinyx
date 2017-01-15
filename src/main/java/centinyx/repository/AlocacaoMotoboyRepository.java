package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import centinyx.model.AlocacaoMotoboy;
import centinyx.model.Motoboy;

public interface AlocacaoMotoboyRepository extends JpaRepository<AlocacaoMotoboy, Integer> {
	
	@Query(value = "insert into alocacao_motoboy values (?1,?2)", nativeQuery = true)
	public List<AlocacaoMotoboy> gravaTodosMotoboysAlocados(int idAlocacao, List<Motoboy> idMotoboy);
	
}
