package centinyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.Escala;

public interface EscalaRepository extends JpaRepository<Escala, Integer> {
	
	@Transactional
	int deleteByIdEscala (int idEscala);

}
