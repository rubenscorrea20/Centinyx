package centinyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.Cliente;
import centinyx.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Transactional
	int deleteByIdPedido (int idPedido);
	
	@Query("SELECT c FROM Cliente c WHERE c.nomeFantasia = ?1")
	public Cliente encontraCliente(String nomeFantasia);

}
