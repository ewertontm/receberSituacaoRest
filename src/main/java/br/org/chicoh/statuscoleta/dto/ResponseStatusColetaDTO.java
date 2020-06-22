package br.org.chicoh.statuscoleta.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "responseStatusColeta")
public class ResponseStatusColetaDTO extends StatusColetaAbstractDTO{
	
	public ResponseStatusColetaDTO() {
		super();
	}	
	
	public ResponseStatusColetaDTO(Integer codigo, String descricao) {
		super( codigo, descricao);
	}


	@Override
	public String toString() {
		return "ResponseStatusColetaDTO, getCodigo()=" + getCodigo() + ", getDescricao()=" + getDescricao() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}	
}