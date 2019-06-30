package br.com.esiii.dominio;

public class Usuario extends EntidadeDominio {

	protected String login;
	protected String senha;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
