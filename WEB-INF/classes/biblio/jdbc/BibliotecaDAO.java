package biblio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.entidades.Biblioteca;

public class BibliotecaDAO {
	private Connection con = Conexao.getConnection();

	public void cadastrarBiblioteca (Biblioteca biblioteca) {
		// SQL
		String sql = "INSERT INTO BIBLIOTECA (nome, endereco) VALUES (?, ?)";  // FUNCIONA, ADICIONAR COMO SERIAL

		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, biblioteca.getNomebib());
			preparador.setString(2, biblioteca.getEnderecobib());

			preparador.execute();
			preparador.close();

			System.out.println("Biblioteca cadastrada com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarBiblioteca(Biblioteca biblioteca){
		String sql = "UPDATE BIBLIOTECA SET nome=?, endereco=? WHERE codbib=?";

		try{
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, biblioteca.getNomebib());
			preparador.setString(2, biblioteca.getEnderecobib());
			preparador.setInt(3, biblioteca.getCodbib());

			preparador.execute();
			preparador.close();

			System.out.print("Biblioteca alterada com sucesso");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public List<Biblioteca> buscarBibliotecaALL() {
		// Monta SQL
		String sql = "SELECT * FROM BIBLIOTECA";

		List<Biblioteca> lista = new ArrayList<Biblioteca>();

		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){

				Biblioteca bib = new Biblioteca();

				bib.setCodbib(resultado.getInt("codbib"));
				bib.setNomebib(resultado.getString("nome"));
				bib.setEnderecobib(resultado.getString("endereco"));

				lista.add(bib);

			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}


}
