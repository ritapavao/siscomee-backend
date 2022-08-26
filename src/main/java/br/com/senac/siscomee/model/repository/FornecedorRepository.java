package br.com.senac.siscomee.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senac.siscomee.model.entidades.Fornecedores;
import br.com.senac.siscomee.model.specifications.FornecedoresRet;
import br.com.senac.siscomee.model.specifications.RamoSetoresRet;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedores, Integer> {
	
	@Query(nativeQuery = true,
            value = "select f.id as Id, rs.nm_ramo_setor as NmRamoSetor, f.nm_fornecedor as NmFornecedor, f.nu_cnpj as NuCnpj, f.nu_telefone as NuTelefone, f.ramo_setor_id as RamoSetorId, " +
            		"f.in_ativo as InAtivo, " +
            		"f.usuario_id_atualiza as UsuarioIdAtualiza, f.dt_ult_atualiza as DtUltAtualiza " +
            		"From fornecedores f " +
            		"INNER JOIN ramos_setores as rs " +
            		"ON (f.ramo_setor_id = rs.id) " +
                    "order by f.in_ativo desc")
	List<FornecedoresRet> listarFornecedores();
	
	@Query(nativeQuery = true,
			 value = "select f.id as Id, rs.nm_ramo_setor as NmRamoSetor, f.nm_fornecedor as NmFornecedor, f.nu_cnpj as NuCnpj, f.nu_telefone as NuTelefone, f.ramo_setor_id as RamoSetorId, " +
	            		"f.in_ativo as InAtivo, " +
	            		"f.usuario_id_atualiza as UsuarioIdAtualiza, f.dt_ult_atualiza as DtUltAtualiza " +
	            		"From fornecedores f " +
	            		"INNER JOIN ramos_setores as rs " +
	            		"ON (f.ramo_setor_id = rs.id) " +
	                    "order by f.in_ativo desc")
	List<FornecedoresRet> filtrarFornecedores(@Param("idRamo") Integer idRamo, @Param("nmFornecedor") String nmFornecedor, @Param("situacao") Integer situacao);
	
	@Query(nativeQuery = true,
            value = "select RS.id AS Id, RS.nm_ramo_setor AS NmRamoSetor " +
            		"from ramos_setores RS where in_ativo = '1' " +
                    "order by RS.in_ativo desc")
	List<RamoSetoresRet> getRamoSetores();
	
	@Query(nativeQuery = true,
            value = "select F.* from fornecedores F inner join ramos_setores RS ON (F.ramo_setor_id = RS.id) " +
                    "where RS.id = :ramo and F.nmFornecedor = :nmFornecedor and F.in_ativo = :situacao")
	List<Fornecedores> filtrarFornecedor(@Param("ramo") Long tipo,@Param("nmFornecedor") String nmFornecedor, @Param("situacao") Short situacao);

	List<Fornecedores> findAll(Direction desc, String string);


}
