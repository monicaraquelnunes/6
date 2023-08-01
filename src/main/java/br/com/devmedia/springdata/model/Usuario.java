package br.com.devmedia.springdata.model;

import java.util.Date;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity // Annotation utilizada para informar que uma classe também é uma entidade(tabela do banco) 
@Table (name = "USUARIOS") // Annotation usada para mapear classes de objetos para tabelas em bancos de dados relacionais
@NamedQuery(name = "Usuario.findByDtCadastro",
		query = "select u from Usuario u where u.dtCadastro = ?1"
		) // Annotation utilizada para definir cunsultas SQL nomeadas que podem ser pré compliladas e reutilizadas em diferentes partes da aplicação

public class Usuario extends AbstractPersistable<Long>{ // Refere-se ao início da classe Usuario que estende AbstractPersistable que facilita o desenvolvimento das classes de entidade
	
	
	public Usuario(String login, String senha, Date dtCadastro, int idade) { // Construtor da classe Usuario
		super(); // é para chamar o construtor da classe que está estendendo o AbstractPersistable
		this.login = login; // o atributo login recebe o argumento login
		this.senha = senha; // o atributo senha recebe o argumento senha
		this.dtCadastro = dtCadastro; // o atributo dtCadastro recebe o argumento dtCadastro
		this.idade = idade; // o atributo idade recebe o argumento idade
	}
	@Column(name = "LOGIN", length = 30, nullable = false, unique = true) // Annotation usada para mapear atributos de uma classe de entidade para colunas em uma tabela do banco de dados
	private String login; // Criando o atributo login como String
	@Column(name = "SENHA", length = 6, nullable = false, unique = false) // Annotation usada para mapear atributos de uma classe de entidade para colunas em uma tabela do banco de dados
	private String senha; // Criando o atributo senha como String
	@Column(name = "DATA_CADASTRO", nullable = false, unique = false) // Annotation usada para mapear atributos de uma classe de entidade para colunas em uma tabela do banco de dados
	@Temporal(value = TemporalType.TIMESTAMP) // Annotation usada para mapear atributos de data e hora
	private Date dtCadastro; // Criando o atributo dtCadastro como Date
	@Column(name = "IDADE", nullable = false, unique = false) // Annotation usada para mapear atributos de uma classe de entidade para colunas em uma tabela do banco de dados
	private int idade; // Criando o atributo idade como inteiro
	public String getLogin() { // Método getLogin que retorna uma String
		return login; // Retornando o atributo login que também é do tipo String
	}
	public void setLogin(String login) { // Método setLogin com o argumento login que retorna void(ou seja nada) 
		this.login = login; // o atributo login recebe o argumento login
	}
	public String getSenha() { // Método getSenha que retorna uma String
		return senha; // Retornando o atributo senha que também é do tipo String
	}
	public void setSenha(String senha) { // Método setSenha com o argumento senha que retorna nada(void)
		this.senha = senha; // o atributo senha recebe o argumento senha
	}
	public Date getDtCadastro() { // Método getDtCadastro que retorna um tipo Date
		return dtCadastro; // Retornando o atributo dtCadastro
	}
	public void setDtCadastro(Date dtCadastro) { // Método setDtCadastro com argumento dtCadastro que retorna nada(void)
		this.dtCadastro = dtCadastro; // o atributo dtCadastro que recebe o argumento dtCadastro
	}
	public int getIdade() { // Método gedIdade que retorna um inteiro
		return idade; // Retornado o atributo idade
	}
	public void setIdade(int idade) { // Método setIdde com argumento idade que retorna nada(void)
		this.idade = idade; // o atributo idade que recebe o argumento idade
	}
	
	

}
