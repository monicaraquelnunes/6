package br.com.devmedia.springdata.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devmedia.springdata.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	// nome do método deve conter o atributo da classe
	public Usuario findByLogin(String Login);
	
	// palavra chave da consulta: Betwen
	public List<Usuario>findByIdadeBetwen(int startAge, int endAge);
	
	// consulta por namedQuery
	public List<Usuario>findByDtCadastro(Date dtCadastro);
	
	// consulta por named parameters
	@Query("from Usuario where login = :login and senha = :senha")
	public Usuario findByLoginAndSenha(@Param("login")String login,
	@Param("senha")String senha);
	
	// consulta com ordinal parameters
	@Query("from Usuario where login = ?3 and senha = ?2 and idade = ?1")
	public Usuario findByLoginAndSenhaAndIdade
	(int idade, String senha, String login);
	

}
