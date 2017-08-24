package br.com.project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public abstract @interface IdentificaCampoPesquisa {

	// descri��o do campo para a tela
	String descricaoCampo();

	// campo do banco
	String campoConsulta();

	// posi��o que ir� aparecer no combo
	int principal() default 10000;
}
