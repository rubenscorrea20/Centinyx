package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByNomeFantasia(String nomeFantasia);

	List<Cliente> findByCnpj(String cnpj);
	
	@Transactional
	int deleteByIdCliente (int idCliente);
	
	@Query("SELECT c FROM Cliente c WHERE c.cnpj = :cnpj")
	public Cliente encontraCNPJexistente(@Param("cnpj") String cnpj);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Cliente c SET c.contatoCliente = null WHERE c.nomeFantasia = ?1")
	public void atualizaContatoCliente(String nomeFantasia);
}
