package br.com.devmedia.springdata.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<AuditoriaUsuario> {
	private AuditoriaUsuario auditoriaUsuario;
	
	public void setAuditoriaUsuario(AuditoriaUsuario auditoriaUsuario) {
		this.auditoriaUsuario = auditoriaUsuario;
	}
	
	public Optional<AuditoriaUsuario> getCurrentAuditor() {
		return Optional.ofNullable(auditoriaUsuario);
	}

}
