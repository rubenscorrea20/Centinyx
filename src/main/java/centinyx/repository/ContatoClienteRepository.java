package centinyx.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.ContatoCliente;

public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Integer> {
	
	Page<ContatoCliente> findByNomeContatoContaining(String nomeContato, Pageable page);
	
	@Query("SELECT c FROM ContatoCliente c WHERE c.nomeContato = :nomeContato")
	public ContatoCliente encontraContatoCliente(@Param("nomeContato") String nomeContato);
	
	@Transactional
	int deleteByIdContatoCliente (int idContatoCliente);
}
