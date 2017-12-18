package biblio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import biblio.entidades.Empresta;
import biblio.entidades.Livros;

public class EmprestaDAO {
	private Connection con = Conexao.getConnection();
	
	public void Emprestimo (Empresta empresta) throws Exception {
		// Cálculo do Empréstimo
		Date hoje = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoje);
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		empresta.setDtretirada(df.format(c.getTime())); // passa para a string da entidade Empresta

		java.sql.Date retirada = new java.sql.Date(df.parse(empresta.getDtretirada()).getTime()); // Passa para a variavel local que irá passar para o SQL
		
		c.add(Calendar.DAY_OF_YEAR, 10); // Adiciona 10 dias do emprestimo
		empresta.setDtprevisao(df.format(c.getTime())); // passa para a string da entidade empresta
		
		java.sql.Date previsao = new java.sql.Date(df.parse(empresta.getDtprevisao()).getTime()); // Passa para a variavel local que irá passar para o SQL
		
		
		// SQL 
		String sql = "INSERT INTO EMPRESTA (codmatricula, codlivro, dtretirada, dtprevisao) VALUES (?, ?, ?, ?)";
		
		// PreparedStatement
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, empresta.getCodmatricula());
			preparador.setInt(2, empresta.getCodlivro());
			preparador.setDate(3, retirada);
			preparador.setDate(4, previsao);
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Livro emprestado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Alterar Livro para indisponivel
		String sql1 = "UPDATE LIVROS SET situacao='Indisponivel' WHERE codlivro=?";
		
		try {
			PreparedStatement preparador1 = con.prepareStatement(sql1);
			
			preparador1.setInt(1, empresta.getCodlivro());
			
			preparador1.execute();
			preparador1.close();	
		} catch (SQLException f) {
			f.printStackTrace();
		}
	}
	
	public void DevolverLivro (Empresta empresta) throws ParseException {
		Date hoje = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoje);
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		empresta.setDtentrega(df.format(c.getTime())); // Passa a data de Entrega no formato de String
		
		java.sql.Date entrega = new java.sql.Date(df.parse(empresta.getDtentrega()).getTime()); // Passa para a variavel local que irá passar para o SQL
		
		// SQL para registrar a data de entrega
		String sql = "UPDATE EMPRESTA SET dtentrega=? WHERE codlivro=? AND dtentrega IS NULL";
		
		//PreparedStatement
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setDate(1, entrega);
			preparador.setInt(2, empresta.getCodlivro());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Livro Devolvido!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		// SQL para liberar o livro
		String sql1 = "UPDATE LIVROS SET situacao='Livre' WHERE codlivro=?";
		
		try {
			PreparedStatement preparador1 = con.prepareStatement(sql1);
			
			preparador1.setInt(1, empresta.getCodlivro());
			
			preparador1.execute();
			preparador1.close();	
		} catch (SQLException f) {
			f.printStackTrace();
		}
		
	}
	
	public List<Empresta> ListarEmprestimo () {
		// Monta SQL
		String sql = "SELECT * FROM EMPRESTA";
		
		List<Empresta> lista = new ArrayList<Empresta>();
		
		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
						
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Empresta emp = new Empresta();
				
				emp.setCodmatricula(resultado.getInt("codmatricula"));
				emp.setCodlivro(resultado.getInt("codlivro"));
				Calendar retirada = Calendar.getInstance();
				Calendar previsao = Calendar.getInstance();
				Calendar entrega = Calendar.getInstance();
				
				retirada.setTime(resultado.getDate("dtretirada"));
				previsao.setTime(resultado.getDate("dtprevisao"));
				
				DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
				emp.setDtretirada(df.format(retirada.getTime()));
				emp.setDtprevisao(df.format(previsao.getTime()));
				
				if (resultado.getDate("dtentrega") != null) {
					entrega.setTime(resultado.getDate("dtentrega"));
					emp.setDtentrega(df.format(entrega.getTime()));
				} else {
					emp.setDtentrega(null);
				}
				
				
				
				
				lista.add(emp);
			}
			
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	public void VerificarAluno (Empresta empresta) throws ParseException {
		Date hoje = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoje); // data de hoje
		
		// Pegar data da previsão e comparar com a data de hoje
		Date previsao = new Date();
		Date entrega = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			previsao = formato.parse(empresta.getDtprevisao());
			if (empresta.getDtentrega() != null) entrega = formato.parse(empresta.getDtentrega());
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Data de hoje: " +hoje);
		System.out.println("Previsao de Entrega: " + previsao);
		System.out.println(hoje.compareTo(previsao));
		
		if(entrega == null) {
			if(hoje.compareTo(previsao) > 0) {
				System.out.println("Aluno atrasado");
				
				// Monta SQL
				String sql = "UPDATE ALUNOS SET situacao='Desabilitado' WHERE codmatricula=?";
				
				// PreparedStatement
				try {
					PreparedStatement preparador = con.prepareStatement(sql);
					preparador.setInt(1, empresta.getCodmatricula());
					
					preparador.execute();
					preparador.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Aluno ok");
			} // fim do else
		} // fim do if entrega
	} // encerra public void
	
	
	
	public String PrevisaoLivro (Livros livros) { 
		// SQL
		String sql = "SELECT * FROM EMPRESTA WHERE codlivro=? AND dtentrega IS NULL";
		
		List<Empresta> lista = new ArrayList<Empresta>();
		Empresta empresta = new Empresta();
		
		try{
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, livros.getCodlivro());
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				
				empresta.setCodmatricula(resultado.getInt("codmatricula"));
				empresta.setCodlivro(resultado.getInt("codlivro"));
				Calendar retirada = Calendar.getInstance();
				Calendar previsao = Calendar.getInstance();
				Calendar entrega = Calendar.getInstance();
				
				retirada.setTime(resultado.getDate("dtretirada"));
				previsao.setTime(resultado.getDate("dtprevisao"));
				
				DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
				empresta.setDtretirada(df.format(retirada.getTime()));
				empresta.setDtprevisao(df.format(previsao.getTime()));
				
				if (resultado.getDate("dtentrega") != null) {
					entrega.setTime(resultado.getDate("dtentrega"));
					empresta.setDtentrega(df.format(entrega.getTime()));
				} else {
					empresta.setDtentrega(null);
				}
				
				lista.add(empresta);
				
			}
			
		preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empresta.getDtprevisao();
	}
}
