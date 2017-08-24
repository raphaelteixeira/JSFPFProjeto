package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.framework.implementacao.crud.SimpleJdbcTemplateImpl;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {

	// salva os dados
	void save(T obj) throws Exception;

	void persiste(T obj) throws Exception;

	// salva ou atualiza
	void saveOrUpdate(T obj) throws Exception;

	// realiza update/atualização de dados
	void update(T obj) throws Exception;

	// realiza o delete de dados
	void delete(T obj) throws Exception;

	// salva ou atualiza e retorna objeto em estado persistente
	T merge(T obj) throws Exception;

	// carrega a lista de dados de determinada classe
	List<T> findList(Class<T> entidade) throws Exception;

	// retorna pelo id
	Object findById(Class<T> entidade, Long id) throws Exception;

	T findPorId(Class<T> entidade, Long id) throws Exception;

	// retorna lista pela query
	List<T> findListByQueryDinamica(String query) throws Exception;

	// executa update com HQL
	void executeUpdateQueryDinamica(String query) throws Exception;

	// executa update com SQL
	void executeUpdateSQLDinamica(String sql) throws Exception;

	// limpa a sessão do hibernate
	void clearSession() throws Exception;

	// retira o objeto da sessão do hibernate
	void evict(Object obj) throws Exception;

	Session getSession() throws Exception;

	List<?> getListSQLDinamica(String sql) throws Exception;

	// JDBC do Spring
	JdbcTemplate getJdbcTemplate();

	SimpleJdbcTemplate getSimpleJdbcTemplate();

	SimpleJdbcInsert getSimpleJdbcInsert();

	SimpleJdbcTemplateImpl getSimpleJdbcTemplateImpl();

	Long totalRegistros(String table) throws Exception;

	Query obterQuery(String query) throws Exception;

	List<Object[]> getListSQLDinamicaArray(String sql) throws Exception;

	// carregamento dinamico com JSF e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro,
			int maximoResultado) throws Exception;
}
