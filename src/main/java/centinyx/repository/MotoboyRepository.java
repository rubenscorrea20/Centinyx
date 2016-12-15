package centinyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import centinyx.model.Motoboy;

public interface MotoboyRepository extends JpaRepository<Motoboy, Integer>  {
	
}