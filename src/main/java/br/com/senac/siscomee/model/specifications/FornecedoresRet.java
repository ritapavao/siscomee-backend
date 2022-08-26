package br.com.senac.siscomee.model.specifications;

import java.util.Date;

public interface FornecedoresRet {

	Integer getId();	
	String  getNmFornecedor();
	String  getNuCnpj();
	String  getNuTelefone();
	String  getInAtivo();
	Integer getUsuarioIdAtualiza();
	Date    getDtUltAtualiza();
	Integer getRamoSetorId();
	String  getNmRamoSetor();
}
