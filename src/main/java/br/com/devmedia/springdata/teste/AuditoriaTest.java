package br.com.devmedia.springdata.teste;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.devmedia.springdata.auditing.AuditorAwareImpl;
import br.com.devmedia.springdata.auditing.AuditoriaUsuario;
import br.com.devmedia.springdata.model.Usuario;
import br.com.devmedia.springdata.repository.IUsuarioRepository;

@Component
public class AuditoriaTest {
	@Autowired
	private CrudRepository<AuditoriaUsuario, Long>auditorAwareRepository;
	@Autowired
	private AuditorAwareImpl auditorAware;
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public void auditoria() {
		Usuario u1 = new Usuario("user01@auditoria.com",
				"user1", new Date() , 29);
		usuarioRepository.save(u1);
		
		AuditoriaUsuario auditoria = new AuditoriaUsuario();
		auditoria.setLogin(u1.getLogin());
		auditoria.setAcao(AuditoriaUsuario.Tipo_Acao[0]);
		
		auditorAware.setAuditoriaUsuario(auditoria);
		auditorAwareRepository.save(auditoria);
		
		System.out.println("AuditoriaTest.auditoria : "
				+ auditorAware.getCurrentAuditor());
	}

}
