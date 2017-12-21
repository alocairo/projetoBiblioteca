package biblio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.entidades.Livros;


public class LivrosDAO {
	private Connection con = Conexao.getConnection();

	public void cadastrarLivro (Livros livros) { // insere livro no banco de dados
		// SQL
		String sql = "INSERT INTO LIVROS (titulo, editora, valor, codcategoria, codbib, situacao) VALUES (?, ?, ?, ?, ?, ?)"; // FUNCIONA AUTO INCREMENT

		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, livros.getTitulo());
			preparador.setString(2, livros.getEditora());
			preparador.setDouble(3, livros.getValor());
			preparador.setInt(4, livros.getCodcategoria());
			preparador.setInt(5, livros.getCodbib());
			preparador.setString(6, livros.getSituacaoliv());

			preparador.execute();
			preparador.close();

			System.out.println("Livro cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarLivro (Livros livros) { // Altera os dados do livro no banco de dados
		// SQL
		String sql = "UPDATE LIVROS SET titulo=?, editora=?, valor=?, codcategoria=?, codbib=?, situacao=? WHERE codlivro=?;";

		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, livros.getTitulo());
			preparador.setString(2, livros.getEditora());
			preparador.setDouble(3, livros.getValor());
			preparador.setInt(4, livros.getCodcategoria());
			preparador.setInt(5, livros.getCodbib());
			preparador.setString(6, livros.getSituacaoliv());
			preparador.setInt(7, livros.getCodlivro());

			preparador.execute();
			preparador.close();

			System.out.println("Livro alterado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Livros> buscarLivrosALL() {
		// Monta SQL
		String sql = "SELECT * FROM LIVROS";

		List<Livros> lista = new ArrayList<Livros>();

		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){

				Livros liv = new Livros();

				liv.setCodlivro(resultado.getInt("codlivro"));
				liv.setTitulo(resultado.getString("titulo"));
				liv.setEditora(resultado.getString("editora"));
				liv.setValor(resultado.getDouble("valor"));
				liv.setCodcategoria(resultado.getInt("codcategoria"));
				liv.setCodbib(resultado.getInt("codbib"));
				liv.setSituacaoliv(resultado.getString("situacao"));

				lista.add(liv);


			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Livros> buscarLivrosAtivos() {
		// Monta SQL
		String sql = "SELECT * FROM LIVROS WHERE SITUACAO='Livre'";

		List<Livros> lista = new ArrayList<Livros>();

		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){

				Livros liv = new Livros();

				liv.setCodlivro(resultado.getInt("codlivro"));
				liv.setTitulo(resultado.getString("titulo"));
				liv.setEditora(resultado.getString("editora"));
				liv.setValor(resultado.getDouble("valor"));
				liv.setCodcategoria(resultado.getInt("codcategoria"));
				liv.setCodbib(resultado.getInt("codbib"));
				liv.setSituacaoliv(resultado.getString("situacao"));

				lista.add(liv);


			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Livros> buscarLivrosEmprestados() {
		// Monta SQL
		String sql = "SELECT * FROM LIVROS WHERE SITUACAO='Indisponivel'";

		List<Livros> lista = new ArrayList<Livros>();

		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){

				Livros liv = new Livros();

				liv.setCodlivro(resultado.getInt("codlivro"));
				liv.setTitulo(resultado.getString("titulo"));
				liv.setEditora(resultado.getString("editora"));
				liv.setValor(resultado.getDouble("valor"));
				liv.setCodcategoria(resultado.getInt("codcategoria"));
				liv.setCodbib(resultado.getInt("codbib"));
				liv.setSituacaoliv(resultado.getString("situacao"));

				lista.add(liv);


			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}


}
