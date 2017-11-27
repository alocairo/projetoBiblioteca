package biblio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.entidades.Categoria;

public class CategoriaDAO {
	private Connection con = Conexao.getConnection();
	
	public void cadastrarCategoria(Categoria categoria) {
		// SQL
		String sql = "INSERT INTO CATEGORIA (descricao) VALUES (?)"; // AUTOINCREMENT FUNCIONA
		
		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, categoria.getDescricao());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Categoria cadastrada com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void alterarCategoria (Categoria categoria) {
		// SQL
		String sql = "UPDATE CATEGORIA SET descricao=? WHERE codcategoria=?;";
			
		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, categoria.getDescricao());
			preparador.setInt(2, categoria.getCodcategoria());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Categoria alterada com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deletarCategoria (Categoria categoria) {	
		// Monta SQL
		String sql = "DELETE FROM CATEGORIA WHERE codcategoria=?;";
		
		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, categoria.getCodcategoria());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Categoria excluída com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	}
		
	public List<Categoria> buscarCategoriaALL () {
		// Monta SQL
		String sql = "SELECT * FROM CATEGORIA";
		
		List<Categoria> lista = new ArrayList<Categoria>();
		
		// Constroe o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Categoria cat = new Categoria();
				
				cat.setCodcategoria(resultado.getInt("codcategoria"));
				cat.setDescricao(resultado.getString("descricao"));
				
				lista.add(cat);
				
			}
			
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
