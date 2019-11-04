package com.cursomc.dominio.enums;

public enum StatusPagamento {

	PENDENTE("Pendente"),
	QUITADO("Quitado"),
	CANCEADO("Cancelado");
	
	private String descricao;
	
	private StatusPagamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
