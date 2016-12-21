package centinyx.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import centinyx.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByLogin(String login);
	
	@Query("SELECT u FROM Usuario u WHERE u.login = :login")
	public Usuario encontraLoginUsuario(@Param("login") String login);
	
	@Transactional
	int deleteByIdUsuario (int idUsuario);
	
	@Modifying 
	@Query("UPDATE Usuario SET perfil = null WHERE idUsuario = ?1")
	public List<Usuario> atualizaPerfilUsuario(int idUsuario);
	
}
