package br.com.senac.siscomee.model.dto;

import java.io.Serializable;
import java.util.Date;

public class RamosSetoresDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nmRamoSetor;
	private short inAtivo;
	private int usuarioIdAtualiza;
	private Date dtUltAtualiza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public  String getNmRamoSetor() {
		return nmRamoSetor;
	}

	public void setNmRamoSetor(String nmRamoSetor) {
		this.nmRamoSetor = nmRamoSetor;
	}

	public short getInAtivo() {
		return inAtivo;
	}

	public void setInAtivo(short inAtivo) {
		this.inAtivo = inAtivo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
