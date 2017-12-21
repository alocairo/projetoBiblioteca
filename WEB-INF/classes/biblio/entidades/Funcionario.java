package biblio.entidades;

public class Funcionario {
	private int codfunc;
	private String nomefunc;
	private String enderecofunc;
	private String telefonefunc;
	private double salario; // Verificar decimalFormat
	private int codbib;

	public int getCodfunc() {
		return codfunc;
	}
	public void setCodfunc(int codfunc) {
		this.codfunc = codfunc;
	}
	public String getNomefunc() {
		return nomefunc;
	}
	public void setNomefunc(String nomefunc) {
		this.nomefunc = nomefunc;
	}
	public String getEnderecofunc() {
		return enderecofunc;
	}
	public void setEnderecofunc(String enderecofunc) {
		this.enderecofunc = enderecofunc;
	}
	public String getTelefonefunc() {
		return telefonefunc;
	}
	public void setTelefonefunc(String telefonefunc) {
		this.telefonefunc = telefonefunc;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCodbib() {
		return codbib;
	}
	public void setCodbib(int codbib) {
		this.codbib = codbib;
	}
}
