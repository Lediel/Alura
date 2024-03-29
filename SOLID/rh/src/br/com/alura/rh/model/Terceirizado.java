package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado {

	private String empresa;
	private DadosPessoais dadosPessoais;
	
	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public BigDecimal getSalario() {
		return dadosPessoais.getSalario();
	}
	
	public String getNome() {
		return dadosPessoais.getNome();
	}
	
	public void setNome(String nome) {
		this.dadosPessoais.setNome(nome);
	}
	
	public String getCpf() {
		return dadosPessoais.getCpf();
	}
	
	public void setCpf(String cpf) {
		this.dadosPessoais.setCpf(cpf);
	}
	
	public Cargo getCargo() {
		return dadosPessoais.getCargo();
	}
	
	public void setCargo(Cargo cargo) {
		this.dadosPessoais.setCargo(cargo);
	}

}
