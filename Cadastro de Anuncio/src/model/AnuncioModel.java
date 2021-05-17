package model;

public class AnuncioModel {

	private String nomeDoAnuncio;
	private String cliente; 
	private String dataInicio;
	private String dataTermino;
	private Double investimento;
	private int Id;
	
	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}
	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Double getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Double investimento) {
		this.investimento = investimento;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

}
