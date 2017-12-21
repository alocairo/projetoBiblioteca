package biblio.jdbc;

import java.math.BigInteger;
import java.security.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.entidades.Login;

public class LoginDAO {
	private Connection con = Conexao.getConnection();
	
	public void CriarLogin (Login login) {
		// SQL
		String sql = "INSERT INTO LOGIN (usuario, senha) VALUES (?, md5(?))";
		
		// PreparedStatement com o SQL
		try { 
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login.getUsuario());
			preparador.setString(2, login.getSenha());
			
			preparador.execute();
			preparador.close();
			
			System.out.println("Login criado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Login> buscarLoginALL() { 
		// SQL
		String sql = "SELECT * FROM LOGIN";
		
		List<Login> lista = new ArrayList<Login>();
		
		// PreparedStatement
		try { 
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				
				Login log = new Login();
				
				log.setCodlogin(resultado.getInt("codlogin"));
				log.setUsuario(resultado.getString("usuario"));
				log.setSenha(resultado.getString("senha"));
				
				lista.add(log);
			}
			
			preparador.close();
			System.out.println("Lista de Logins");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Login> buscarLoginUsuario(Login login) {
		// SQL
		String sql = "SELECT * FROM LOGIN where usuario=?";
		
		List<Login> lista = new ArrayList<Login>();
		
		// PreparedStatement
		try { 
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login.getUsuario());
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				
				Login log = new Login();
				
				log.setCodlogin(resultado.getInt("codlogin"));
				log.setUsuario(resultado.getString("usuario"));
				log.setSenha(resultado.getString("senha"));
				
				lista.add(log);
			}
			
			preparador.close();
			System.out.println("Lista de Logins");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	
	public String CriptografaSenha(Login login) throws Exception {
		String senha = login.getSenha();
		MessageDigest message = MessageDigest.getInstance("MD5");
		message.update(senha.getBytes(),0,senha.length());
		String verificador = new BigInteger(1,message.digest()).toString(16);

		return verificador;
	}
	

}
