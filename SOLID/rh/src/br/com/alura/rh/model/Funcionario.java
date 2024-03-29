package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {

	
	private LocalDate dataUltimoReajuste;
	private DadosPessoais dadosPessoais;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.dadosPessoais = new DadosPessoais(nome, cpf, cargo, salario);
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.dadosPessoais.setSalario(novoSalario);
		this.dataUltimoReajuste = LocalDate.now();
	}

	public void promover(Cargo novoCargo) {
		this.dadosPessoais.setCargo(novoCargo);
	}
	
	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
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
