package model;

public class Locatario {
	private int id;
	private String nome;
	private String endereco;
	private char sexo;
	
	public Locatario() {
		this.id = -1;
		this.nome = "";
		this.endereco = "";
		this.sexo = '*';
	}
	
	public Locatario(int id, String nome, String endereco, char sexo) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Locatario [ id = " + id + ", nome = " + nome + ", endereco = " + endereco + ", sexo = " + sexo + " ]";
	}	
}
