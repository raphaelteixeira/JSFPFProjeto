package br.com.project.listener;

import java.io.Serializable;

import org.hibernate.envers.RevisionListener;
import org.springframework.stereotype.Service;

import br.com.framework.utils.UtilFramework;
import br.com.project.model.classes.Entidade;
import br.com.project.model.classes.InformacaoRevisao;

@Service
public class CustomListener implements RevisionListener, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void newRevision(Object revisionEntity) {
		InformacaoRevisao informacaoRevisao = (InformacaoRevisao) revisionEntity;
		Long codigoUser = UtilFramework.getThreadLocal().get();

		Entidade entidade = new Entidade();

		if (codigoUser != null && codigoUser != 0L) {
			entidade.setEnt_codigo(codigoUser);
			informacaoRevisao.setEntidade(entidade);
		}
	}
}
