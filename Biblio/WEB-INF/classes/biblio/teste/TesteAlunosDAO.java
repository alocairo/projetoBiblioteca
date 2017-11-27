package biblio.teste;

import java.util.List;

import biblio.entidades.Alunos;
import biblio.entidades.Biblioteca;
import biblio.entidades.Login;
import biblio.jdbc.AlunosDAO;
import biblio.jdbc.BibliotecaDAO;
import biblio.jdbc.LivrosDAO;
import biblio.jdbc.LoginDAO;

public class TesteAlunosDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login log = new Login();
		log.setUsuario("preto");
		log.setSenha("admin");
		
		LoginDAO logDAO = new LoginDAO();
		logDAO.CriarLogin(log);
	}

}
