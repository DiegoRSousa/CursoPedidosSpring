package com.cursomc.dominio.enums;

public enum TipoCliente {

	PESSOAFISICA("Pessoa Física"),
	PESSOAJURIDICA("Pessoa Jurídica");
	
	private String descricao;
	
	private TipoCliente(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}