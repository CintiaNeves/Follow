package br.com.esiii.dominio;

import java.util.List;

public class Curso extends EntidadeDominio{

	private String nomeCurso;
	private List<Turma> turmas;
	private GradeHoraria grade;
	
	
	public Curso(){
		
	}
	public Curso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public GradeHoraria getGrade() {
		return grade;
	}
	public void setGrade(GradeHoraria grade) {
		this.grade = grade;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
}
