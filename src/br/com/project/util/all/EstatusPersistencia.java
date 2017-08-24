package br.com.project.util.all;

public enum EstatusPersistencia {
	ERRO("Erro"), SUCESSO("Sucesso"), OBJETO_REFERENCIADO(
			"Esse objeto não pode ser apagado por possuir referências ao mesmo.");

	private String name;

	private EstatusPersistencia(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
