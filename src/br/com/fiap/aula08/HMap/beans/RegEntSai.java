package br.com.fiap.aula08.HMap.beans;

import java.util.Date;

public class RegEntSai {
	
	
	private Date dataEnt;
	private Date dataSai;
	

	//Construtor padrão
	public RegEntSai() {}

	//Construtor com argumentos
	public RegEntSai(Date dataEnt, Date dataSai) {
		this.dataEnt = dataEnt;
		this.dataSai = dataSai;
	}

	//Getters e setters
	public Date getDataEnt() {
		return dataEnt;
	}

	public void setDataEnt(Date dataEnt) {
		this.dataEnt = dataEnt;
	}

	public Date getDataSai() {
		return dataSai;
	}

	public void setDataSai(Date dataSai) {
		this.dataSai = dataSai;
	}
	
	
	
	
	
	
	
	
}
