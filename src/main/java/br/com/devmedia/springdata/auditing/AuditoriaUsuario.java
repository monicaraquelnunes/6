package br.com.devmedia.springdata.auditing;

import org.springframework.data.jpa.domain.AbstractAuditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "AUDITORIA_USUARIO")
public class AuditoriaUsuario extends AbstractAuditable<AuditoriaUsuario, Long> {
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "ACAO")
	private String acao;
	@Transient
	public static final String[] Tipo_Acao = {"Save", "Update", "Delete"};
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

}
