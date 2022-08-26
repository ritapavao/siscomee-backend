package br.com.senac.siscomee.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.siscomee.model.dto.FornecedoresDTO;
import br.com.senac.siscomee.model.entidades.Fornecedores;
import br.com.senac.siscomee.model.repository.FornecedorRepository;
import br.com.senac.siscomee.model.specifications.FornecedoresRet;
import br.com.senac.siscomee.model.specifications.RamoSetoresRet;


@Service
public class FornecedorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FornecedorService.class);
    private Date dataLocal = new Date();

    @Autowired
	private FornecedorRepository fornecedorRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<FornecedoresRet> listarFornecedores() {
    	return this.fornecedorRepository.listarFornecedores();
	}

	public List<FornecedoresDTO> listarDocsOrcamentariosDTO()
	{
		List<FornecedoresDTO> listaDTO = new ArrayList<>();
		
		for(Fornecedores Fornecedor : this.fornecedorRepository.findAll()) {
			FornecedoresDTO dto = new FornecedoresDTO();
				 dto.setId(Fornecedor.getId());
				 dto.setNmFornecedor(Fornecedor.getNmFornecedor());
				 dto.setNuCnpj(Fornecedor.getNuCnpj());
				 dto.setNuTelefone(Fornecedor.getNuTelefone());
	             dto.setRamoSetorId(Fornecedor.getRamoSetorId().getId());
	             dto.setNmRamoSetor(Fornecedor.getRamoSetorId().getNmRamoSetor());
				 dto.setInAtivo(Fornecedor.getInAtivo());
				 dto.setDtUltAtualiza(Fornecedor.getDtUltAtualiza());
				 dto.setUsuarioIdAtualiza(Fornecedor.getUsuarioIdAtualiza());
				 listaDTO.add(dto);
			}
			
			return listaDTO;
	}
	
	public Fornecedores addFornecedor(Fornecedores fornecedor)
	{
		return fornecedorRepository.save(fornecedor);
	}
	
	public Fornecedores atualizarFornecedor(Fornecedores fornecedor)
	{
		Fornecedores Fornecedor = fornecedorRepository.findById(fornecedor.getId()).orElse(null);

		Fornecedor.setNmFornecedor(fornecedor.getNmFornecedor());
		Fornecedor.setNuCnpj(fornecedor.getNuCnpj());
		Fornecedor.setNuTelefone(fornecedor.getNuTelefone());
		Fornecedor.setInAtivo(fornecedor.getInAtivo());
		Fornecedor.setRamoSetorId(fornecedor.getRamoSetorId());
		Fornecedor.setUsuarioIdAtualiza(fornecedor.getUsuarioIdAtualiza());
		Fornecedor.setDtUltAtualiza(this.dataLocal);
		
		return fornecedorRepository.save(Fornecedor);
	}
	
	// combo ramo(setores)
	public List<RamoSetoresRet> getRamoSetores()
	{
		return fornecedorRepository.getRamoSetores();
	}
	
	public Fornecedores getFornecedorById(int id)
	{
		return fornecedorRepository.findById(id).orElse(null);
	}	
	
	public Fornecedores inativarFornecedorByID(int idFornecedor)
	{
		Fornecedores Fornecedor = fornecedorRepository.findById(idFornecedor).orElse(null);

		Fornecedor.setInAtivo((short) 0);		
		Fornecedor.setDtUltAtualiza(this.dataLocal);

		return fornecedorRepository.save(Fornecedor);
	}
	
	public List<FornecedoresDTO> filtrarFornecedores(int idRamo, String nmFornecedor, int situacao)
	{
		String Sql = "select F from Fornecedores F "
				   
				   	+ "where 1=1";

					if(idRamo != 0)
					{
						Sql += " and F.ramoSetorId = " + idRamo;
					}
					
					if(!nmFornecedor.equals(null) && !nmFornecedor.equals("nulo"))
					{
						Sql += " and F.nmFornecedor like '%" + nmFornecedor + "%'";
					}
					
					if(situacao != -1)
					{
						Sql += " and F.inAtivo = " + situacao;
					}
				
					   	Sql += " order by F.inAtivo desc";

					Query q = entityManager.createQuery(Sql);
		
					List<Fornecedores> Lista = q.getResultList();
					
					List<FornecedoresDTO> listaDTO = new ArrayList<>();
					
					for(Fornecedores Fornecedor : Lista)
					{
						FornecedoresDTO dto = new FornecedoresDTO();
							 
							 dto.setId(Fornecedor.getId());
							 dto.setNmFornecedor(Fornecedor.getNmFornecedor());
							 dto.setNuCnpj(Fornecedor.getNuCnpj());
							 dto.setNuTelefone(Fornecedor.getNuTelefone());
				             dto.setRamoSetorId(Fornecedor.getRamoSetorId().getId());
							 dto.setInAtivo(Fornecedor.getInAtivo());
							 dto.setNmRamoSetor(Fornecedor.getRamoSetorId().getNmRamoSetor());
							 dto.setDtUltAtualiza(Fornecedor.getDtUltAtualiza());
							 dto.setUsuarioIdAtualiza(Fornecedor.getUsuarioIdAtualiza());
							 listaDTO.add(dto);
					}
						
					return listaDTO;
	}
	
	public Boolean unicidade(int idRamo, String nmFornecedor, String id)
	{
		String Sql = "select f from Fornecedores f "
				   	+ "where 1=1 "
					+ "and f.ramoSetorId = " + idRamo;
					
					if(!nmFornecedor.equals(null) && !nmFornecedor.equals("nulo"))
					{
						Sql += " and f.nmFornecedor = '" + nmFornecedor + "'";
					}

					if(!id.equals("null"))
					{
						Sql += " and f.id != " + id;
					}

					Query q = entityManager.createQuery(Sql);
		
					List<Fornecedores> Lista = q.getResultList();
						
					return Lista.size() > 0 ? false : true;
	}

	@Transactional
	public void execute(String sql)
	{
		entityManager.createNativeQuery(sql).getResultList();		
	}
}