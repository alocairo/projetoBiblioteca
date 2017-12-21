package biblio.entidades;

public class Empresta {
	private int codmatricula;
	private int codlivro;
	private String dtretirada;
	private String dtprevisao;
	private String dtentrega;


	public int getCodmatricula() {
		return codmatricula;
	}
	public void setCodmatricula(int codmatricula) {
		this.codmatricula = codmatricula;
	}
	public int getCodlivro() {
		return codlivro;
	}
	public void setCodlivro(int codlivro) {
		this.codlivro = codlivro;
	}

	public String getDtretirada() {
		return dtretirada;
	}
	public void setDtretirada(String dtretirada) {
		this.dtretirada = dtretirada;
	}
	public String getDtprevisao() {
		return dtprevisao;
	}
	public void setDtprevisao(String dtprevisao) {
		this.dtprevisao = dtprevisao;
	}
	public String getDtentrega() {
		return dtentrega;
	}
	public void setDtentrega(String dtentrega) {
		this.dtentrega = dtentrega;
	}



}
