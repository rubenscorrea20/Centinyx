package centinyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import centinyx.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>  {
	
	List<Funcionario> findByNomeCompleto(String funcionario);
	List<Funcionario> findByIdFuncionario(int id);
	
	
}