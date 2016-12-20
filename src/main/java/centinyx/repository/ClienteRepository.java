package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import centinyx.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByNomeFantasia(String nomeFantasia);

	List<Cliente> findByCnpj(String cnpj);
}
