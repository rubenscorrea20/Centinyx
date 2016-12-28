package centinyx.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import centinyx.model.Motoboy;

public interface MotoboyRepository extends JpaRepository<Motoboy, Integer>  {

	Page<Motoboy> findByFuncionarioNomeContaining(String nome, Pageable p);
}