package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import centinyx.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>  {
	
	List<Funcionario> findByNomeCompleto(String funcionario);
	
	List<Funcionario> findByIdFuncionario(int id);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nomeCompleto = :nomeFuncionario")
	public Funcionario encontraNomeFuncionario(@Param("nomeFuncionario") String nomeFuncionario);
	
	
}