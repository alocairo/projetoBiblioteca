package biblio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.entidades.Funcionario;


public class FuncionarioDAO {
	private Connection con = Conexao.getConnection();
	
	public void cadastrarFuncionario (Funcionario funcionario) {
		// SQL
		String sql = "INSERT INTO FUNCIONARIO (nome, endereco, telefone, salario, codbib) VALUES (?, ?, ?, ?, ?)"; // AUTO INCREMENT FUNCIONA, ADICIONAR ID COMO SERIAL
				
				// PreparedStatement com o SQL
				try {
					PreparedStatement preparador = con.prepareStatement(sql);
					preparador.setString(1, funcionario.getNomefunc());
					preparador.setString(2, funcionario.getEnderecofunc());
					preparador.setString(3, funcionario.getTelefonefunc());
					preparador.setDouble(4, funcionario.getSalario());
					preparador.setInt(5, funcionario.getCodbib());
					
					preparador.execute();
					preparador.close();
					
					System.out.println("Funcionario cadastrado com sucesso!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}
	
	public void alterarFuncionario (Funcionario funcionario) {
		// SQL
		String sql = "UPDATE FUNCIONARIO nome=?, endereco=?, telefone=?, salario=?, codbib=? WHERE codfunc=?;";
			
		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, funcionario.getNomefunc());
			preparador.setString(2, funcionario.getEnderecofunc());
			preparador.setString(3, funcionario.getTelefonefunc());
			preparador.setDouble(4, funcionario.getSalario());
			preparador.setInt(5, funcionario.getCodbib());
			preparador.setInt(6, funcionario.getCodfunc());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Funcionario alterado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}
	
	public void deletarFuncionario (Funcionario funcionario) {
		// Monta SQL
		String sql = "DELETE FROM FUNCIONARIO WHERE codfunc=?;";
		
		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, funcionario.getCodfunc());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Funcionario excluído com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> buscarFuncionarioALL() {
		// Monta SQL
		String sql = "SELECT * FROM FUNCIONARIO";
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				
				Funcionario func = new Funcionario();
				
				func.setCodfunc(resultado.getInt("codfunc"));
				func.setNomefunc(resultado.getString("nome"));
				func.setEnderecofunc(resultado.getString("endereco"));
				func.setTelefonefunc(resultado.getString("telefone"));
				func.setSalario(resultado.getDouble("salario"));
				func.setCodbib(resultado.getInt("codbib"));
				
				lista.add(func);
				
			}
			
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
}
