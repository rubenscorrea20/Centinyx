package centinyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import centinyx.enums.TipoPeriodoEnum;
import centinyx.model.PeriodoAlocacao;

public interface PeriodoAlocacaoRepository extends JpaRepository<PeriodoAlocacao, Integer> {
	
	@Query(value = "SELECT * FROM periodo_alocacao p join Cliente c on p.id_cliente = c.id_cliente and p.tipo_periodo = :tipoPeriodo and c.nome_fantasia = :nomeFantasia", nativeQuery = true)
	public PeriodoAlocacao encontraPeriodoAlocacao(@Param("tipoPeriodo") TipoPeriodoEnum tipoPeriodo, @Param("nomeFantasia") String nomeFantasia);
}
