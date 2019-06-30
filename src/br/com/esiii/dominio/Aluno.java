package br.com.esiii.dominio;


import java.util.Calendar;
import java.util.List;

public class Aluno extends Pessoa {

	private Calendar dataMatricula;
	private Ra ra;
	private Matricula matricula;
	private List<Nota> notas;
	private List<Media> medias;
	private Curso curso;
	private int semestre;
	
	public Aluno (){
		
	}
	
	public Aluno(int id, String nome, String sexo, String cpf, Calendar dataNascimento, 
			String rg, String email, Endereco endereco, Telefone telefone, Curso curso, Ra ra){
		
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.curso = curso;
		this.ra = ra;
		
	}

	public Calendar getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Calendar dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	public Ra getRa() {
		return ra;
	}
	
	public void setRa(Ra ra) {
		this.ra = ra;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
}
