package biblio.entidades;

public class Livros {
	private int codlivro;
	private int codbib;
	private int codcategoria;
	private String titulo;
	private String editora;
	private double valor;
	private String situacaoliv;
	public int getCodlivro() {
		return codlivro;
	}
	public void setCodlivro(int codlivro) {
		this.codlivro = codlivro;
	}

	public int getCodbib() {
		return codbib;
	}
	public void setCodbib(int codbib) {
		this.codbib = codbib;
	}
	public int getCodcategoria() {
		return codcategoria;
	}
	public void setCodcategoria(int codcategoria) {
		this.codcategoria = codcategoria;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getSituacaoliv() {
		return situacaoliv;
	}
	public void setSituacaoliv(String situacaoliv) {
		this.situacaoliv = situacaoliv;
	}


}
