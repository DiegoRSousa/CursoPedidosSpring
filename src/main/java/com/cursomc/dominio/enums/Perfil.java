package com.cursomc.dominio.enums;

public enum Perfil {

	ADMIN("ROLE_ADMIN"),
	CLIENTE("ROLE_CLIENTE");
	
	private String descricao;
	
	private Perfil(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
