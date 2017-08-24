package br.com.project.acessos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum Permissao {
	ADMIN("ADMIN", "Administrador"), USER("USER", "Usuário Padrão"), CADASTRO_ACESSAR(
			"CADASTRO_ACESSAR", "Cadastrko - acessar"), FINANCEIRO_ACESSAR(
			"FINANCEIRO_ACESSAR", "Financeiro - acessar"), MENSAGEM_ACESSAR(
			"MENSAGEM_ACESSAR", "Mensagem recebida - acessar"),

	BAIRRO_ACESSAR("BAIRRO_ACESSAR", "Bairro - acessar"), BAIRRO_NOVO(
			"BAIRRO_NOVO", "Bairro - Novo"), BAIRRO_EDITAR("BAIRRO_EDITAR",
			"Bairro - Editar"), BAIRRO_EXCLUIR("BAIRRO_EXCLUIR",
			"Bairro - Excluri");

	private String valor = "";
	private String descricao = "";

	private Permissao(String name, String descricao) {
		this.valor = name;
		this.descricao = descricao;
	}

	private Permissao() {
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static List<Permissao> getListPermissao() {
		List<Permissao> permissoes = new ArrayList<Permissao>();

		for (Permissao permissao : Permissao.values()) {
			permissoes.add(permissao);
		}

		Collections.sort(permissoes, new Comparator<Permissao>() {
			@Override
			public int compare(Permissao p1, Permissao p2) {
				return new Integer(p1.ordinal()).compareTo(new Integer(p2
						.ordinal()));
			}
		});

		return permissoes;
	}

	@Override
	public String toString() {
		return getValor();
	}

}
