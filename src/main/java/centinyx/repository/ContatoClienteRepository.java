package centinyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import centinyx.model.ContatoCliente;

public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Integer> {

}
