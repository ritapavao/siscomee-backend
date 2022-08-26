package br.com.senac.siscomee.model.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rita.pavao
 */
@Entity
@Table(name = "fornecedores",  schema = "")
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f")})
public class Fornecedores implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nm_fornecedor")
    private String nmFornecedor;
    @Basic(optional = false)
    @Column(name = "nu_cnpj")
    private String nuCnpj;
    @Basic(optional = false)
    @Column(name = "nu_telefone")
    private String nuTelefone;
    @Basic(optional = false)
    @Column(name = "in_ativo")
    private short inAtivo;
    //@JsonManagedReference
    @JoinColumn(name = "ramo_setor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RamosSetores ramoSetorId;
    @Basic(optional = false)
    @Column(name = "usuario_id_atualiza")
    private int usuarioIdAtualiza;
	@Basic(optional = false)
    @Column(name = "dt_ult_atualiza")
    private Date dtUltAtualiza;
	
	
    public Fornecedores() {
    }

    public Fornecedores(Integer id) {
        this.id = id;
    }

    public Fornecedores(Integer id, String nmFornecedor, String nuCnpj, String nuTelefone, short inAtivo, int usuarioIdAtualiza, Date dtUltAtualiza) {
        this.id = id;
        this.nmFornecedor = nmFornecedor;
        this.nuCnpj = nuCnpj;
        this.nuTelefone = nuTelefone;
        this.inAtivo = inAtivo;
        this.usuarioIdAtualiza = usuarioIdAtualiza;
        this.dtUltAtualiza = dtUltAtualiza;
    }

    
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


	public RamosSetores getRamoSetorId() {
		return ramoSetorId;
	}

	public void setRamoSetorId(RamosSetores ramoSetorId) {
		this.ramoSetorId = ramoSetorId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senac.siscomee.model.entidades.Fornecedores[ id=" + id + " ]";
    }

	
    
}
