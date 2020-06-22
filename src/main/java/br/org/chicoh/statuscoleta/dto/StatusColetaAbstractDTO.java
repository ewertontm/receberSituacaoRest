package br.org.chicoh.statuscoleta.dto;

public abstract class StatusColetaAbstractDTO {	
	
	private Integer codigo;
	private String descricao;
	
	public StatusColetaAbstractDTO() {
		super();
	}
	
	public StatusColetaAbstractDTO(Integer codigo, String descricao) {
		super();
		
		this.codigo = codigo;
		this.descricao = descricao;
	}


	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());		
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusColetaAbstractDTO other = (StatusColetaAbstractDTO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;		
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "StatusColetaDTO [ codigo=" + codigo
				+ ", descricao=" + descricao + "]";
	}
}