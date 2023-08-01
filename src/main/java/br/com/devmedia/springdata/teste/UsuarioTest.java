package br.com.devmedia.springdata.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.devmedia.springdata.model.Usuario;
import br.com.devmedia.springdata.repository.IUsuarioRepository;

@Component
public class UsuarioTest {
	@Autowired
	private IUsuarioRepository repository;
	
	public void salvar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2011, 11, 8, 16, 42, 44);
		Usuario u5 = new Usuario("java07@email.com", "teste7",
				calendar.getTime(), 35);
		repository.save(u5);
	}
	
	public void salvarLista() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("java01@email.com", "teste1", new Date(), 20);
		Usuario u2 = new Usuario("java02@email.com", "teste2", new Date(), 22);
		Usuario u3 = new Usuario("java03@email.com", "teste3", new Date(), 26);
		Usuario u4 = new Usuario("java04@email.com", "teste4", new Date(), 30);
		usuarios.add(u1); usuarios.add(u2); usuarios.add(u3); usuarios.add(u4);
		List<Usuario>users = repository.saveAll(usuarios);	
	}
	
	public void excluir() {
		List<Usuario>usuarios = repository.findAll();
		Usuario usuario = usuarios.get(0);
		repository.delete(usuario);
	}
	
	public void findByLogin() {
		Usuario usuario = repository.findByLogin("java02@email.com");
		System.out.println(usuario.toString());
	}
	
	public void findByIdadeBetween() {
		List<Usuario>usuarios = repository.findByIdadeBetwen(25, 35);
		for(Usuario u: usuarios)
			System.out.println(u.toString());
	}
	
	public void findByDtCadastro() {
		Calendar c = Calendar.getInstance();
		c.set(2011, 11, 8, 16, 42, 44);
		List<Usuario> usuarios = repository.findByDtCadastro(c.getTime());
		for (Usuario u:usuarios)
			System.out.println(u.toString());
	}
	
	public void findByLoginAndSenha() {
		Usuario usuario = repository
				.findByLoginAndSenha("teste2", "java02@email.com");
		System.out.println(usuario.toString());
	}
	
	public void findByLoginAndSenhaAndIdade() {
		Usuario usuario = repository
				.findByLoginAndSenhaAndIdade(30, "teste4", "java04@email.com");
		System.out.println(usuario.toString());
	}

}
