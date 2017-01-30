package centinyx.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.Alocacao;
import centinyx.model.Motoboy;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	//@Query(value = "UPDATE Alocacao a SET a.pedido = :idPedido WHERE a.idAlocacao in :idAlocacao")
	@Query(value = "UPDATE Alocacao SET id_pedido = ?1 WHERE id_alocacao in ?2", nativeQuery = true)
	public void atualizaAlocacaoPedido(int idPedido, List<Integer> idAlocacao);
	
	@Query("SELECT m FROM Motoboy m, Funcionario f WHERE m.funcionario = f.idFuncionario and f.nome in :motoboy")
	public List<Motoboy> encontraMotoboysAlocados(@Param("motoboy") List<String> motoboy);
	
	
	@Query(value = "SELECT a.id_alocacao FROM Alocacao a, Pedido p WHERE a.numero_pedido = p.numero_pedido and a.numero_pedido = ?1", nativeQuery = true)
	public ArrayList<Integer> buscaAlocacoes(int numeroPedido);
	
	List<Alocacao> findByNumeroPedido(int numeroPedido);
	

}
