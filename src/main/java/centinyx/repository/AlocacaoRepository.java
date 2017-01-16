package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.Alocacao;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Alocacao a SET a.pedido = ?1 WHERE a.idAlocacao in (?2)")
	public void atualizaAlocacaoPedido(int idPedido, List<Integer> idAlocacao);

}
