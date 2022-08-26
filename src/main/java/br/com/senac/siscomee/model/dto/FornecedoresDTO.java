package br.com.senac.siscomee.model.dto;

import java.io.Serializable;
import java.util.Date;

public class FornecedoresDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	private Integer id;
    private String nmFornecedor;
	private String nuCnpj;
	private String nuTelefone;
	private short inAtivo;
	private Integer ramoSetorId;
	private String nmRamoSetor;
	private int usuarioIdAtualiza;
	private Date dtUltAtualiza;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNmFornecedor() {
		return nmFornecedor;
	}
	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}
	public String getNuCnpj() {
		return nuCnpj;
	}
	public void setNuCnpj(String nuCnpj) {
		this.nuCnpj = nuCnpj;
	}
	public String getNuTelefone() {
		return nuTelefone;
	}
	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}
	public short getInAtivo() {
		return inAtivo;
	}
	public void setInAtivo(short s) {
		this.inAtivo = s;
	}
	
	public int getRamoSetorId() {
		return ramoSetorId;
	}
	public void setRamoSetorId(int i) {
		this.ramoSetorId = i;
	}
	
	public int getUsuarioIdAtualiza() {
		return usuarioIdAtualiza;
	}
	public void setUsuarioIdAtualiza(int usuarioIdAtualiza) {
		this.usuarioIdAtualiza = usuarioIdAtualiza;
	}
	public Date getDtUltAtualiza() {
		return dtUltAtualiza;
	}
	public void setDtUltAtualiza(Date dtUltAtualiza) {
		this.dtUltAtualiza = dtUltAtualiza;
	}
	
	public String getNmRamoSetor() {
		return nmRamoSetor;
	}
	public void setNmRamoSetor(String string) {
		this.nmRamoSetor = string;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
    
}
