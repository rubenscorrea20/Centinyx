package centinyx.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import centinyx.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>  {
	
	List<Funcionario> findByNome(String funcionario);
	
	List<Funcionario> findByIdFuncionario(int id);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome")
	public Funcionario encontraNomeFuncionario(@Param("nome") String nome);
	
	@Transactional
	int deleteByIdFuncionario (int idFuncionario);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Funcionario f SET f.usuario = null WHERE f.nome = ?1")
	public void atualizaUsuarioFuncionario(String nome);
	
}