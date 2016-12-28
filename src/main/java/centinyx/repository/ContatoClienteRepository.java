package centinyx.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.ContatoCliente;

public interface ContatoClienteRepository extends JpaRepository<ContatoCliente, Integer> {
	
	Page<ContatoCliente> findByNomeContaining(String nome, Pageable p);
	
	@Query("SELECT c FROM ContatoCliente c WHERE c.nome = :nome")
	public ContatoCliente encontraContatoCliente(@Param("nome") String nome);
	
	@Transactional
	int deleteByIdContatoCliente (int idContatoCliente);
}
