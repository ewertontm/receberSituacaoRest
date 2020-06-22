package br.org.chicoh.statuscoleta.dto;

public class ParametrosEntrada {
	
	private Integer codigo;
	private String descricao;
	private Long ticket;

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getTicket() {
		return ticket;
	}
	public void setTicket(Long ticket) {
		this.ticket = ticket;
	}
	

}
