package br.com.devmedia.springdata.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// Classe de entidade Usuario(modo tradicional)
@Entity // Annotation utilizada para informar que uma classe também é uma entidade(tabela do banco)
@Table(name = "USUARIOS") // Annotation utilizada para mapear classes de objetos para tabelas em bancos de dados relacionais
public class UsuarioAntigo implements Serializable { // Início da Classe UsuarioAntigo que implementa Serializable que serve para gerar um id quando transformar essa classe em objeto
	private static final long serialVersionUID = -2420346134960559062L; 
	
	@Id // Annotation para indicar que o atributo id em uma classe de entidade representa a chave primária da tabela do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation para indicar que o valor de um atributo deve ser gerado automaticamente pelo banco de dados durante a persistencia de uma entidade.
	@Column(name = "ID_PROPRIERATIO") // Annotation usada para mapear atributos de uma classe de entidade para colunas em uma tabela do banco de dados
	private Long id; // Criando o atributo id como Long
	
	@Column(name = "LOGIN", length = 30, nullable = false, unique = true)
	private String login; // Criando o atributo login como String
	
	@Column(name = "SENHA", length = 6, nullable = false, unique = false)
	private String senha; // Criando o atributo senha como String
	
	@Column(name = "DATA_CADASTRO", nullable = false, unique = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dtCadastro; // Criando o atributo dtCadastro como Date
	
	@Column(name = "IDADE", nullable = false, unique = false)
	private int idade; // Criando o atributo idade como int
	
	public Long getId() { // Método getId que retorna Long
		return id; // Retornando o atributo id
	}
	public void setId(Long id) { // Método setId com o argumento id que retorna void(nada)
		this.id = id; // o atributo id recebe o argumento id
	}
	public String getLogin() { // Método getLogin que retorna uma String
		return login; // Retornando o atributo login
	}
	public void setLogin(String login) { // Método setLogin com o argumento login que retorna void(nada)
		this.login = login; // o atributo login recebe o argumento login
	}
	public String getSenha() { // Método getSenha que retorna uma String
		return senha; // Retornando o atributo senha
	}
	public void setSenha(String senha) { // Método setSenha com argumento senha que retorna void(nada)
		this.senha = senha; // o atributo senha recebe o argumento senha
	}
	public Date getDtCadastro() { // Método getDtCadastro que retorna um tipo Date
		return dtCadastro; // Retornando o atributo dtCadastro
	}
	public void setDtCadastro(Date dtCadastro) { // Método setDtCadastro com argumento dtCadastro que retorna void(nada)
		this.dtCadastro = dtCadastro; // o atributo dtCadastro recebe o argumento dtCadastro
	}
	public int getIdade() { // Método getIdade que retorna um inteiro
		return idade; // Retornando o atributo idade
	}
	public void setIdade(int idade) { // Método setIdade com argumento idade que retorna void(nada)
		this.idade = idade; // o atributo idade recebe o argumento idade
	}
	public static long getSerialversionuid() { // Método getSerialversionuid que retorna um long
		return serialVersionUID; // Retornando o atributo serialVersionUID
	}
	@Override // Annotation usada para indicar que um método está sobrescrevendo(override) um método da superclasse ou interface 
	public int hashCode() { // Método hashCode que retorna um inteiro
		return Objects.hash(id); // Retornando o método hash para embaralhar o conteúdo do atributo(id)
		
	}
	@Override
	public boolean equals(Object obj) { // Método equals com argumento obj que retorna um boolean
		if (this == obj) // se este(método equals) for igual ao argumento obj
			return true; // Retornando verdadeiro
		if (obj == null) // se este(método equal) for igual a nulo
			return false; // retornando falso
		if (getClass() != obj.getClass()) // se o método getClass for diferente do método getClass do objeto criado no argumento
			return false; // retornando falso
		UsuarioAntigo other = (UsuarioAntigo) obj; // o objeto other recebe o objeto obj
		return Objects.equals(id, other.id); // retornando o método equals comparando o atributo id com o atributo other.id
	}
		

}
