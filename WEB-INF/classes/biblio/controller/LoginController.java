package biblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.entidades.Login;
import biblio.jdbc.LoginDAO;


@WebServlet("/logcontroller.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obter a lista
		LoginDAO logDAO = new LoginDAO();
		List <Login> lista = logDAO.buscarLoginALL();
		
		// Engavetar a lista no request
		request.setAttribute("lista", lista);
		
		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listarusuarios.jsp");
		saida.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Receber dados
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		// Criar objeto e receber parametros
		Login log = new Login();
		log.setUsuario(usuario);
		log.setSenha(senha);
		String verificador = null;
		LoginDAO logDAO = new LoginDAO();
		try {
			verificador = logDAO.CriptografaSenha(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Login> lista = logDAO.buscarLoginUsuario(log);
		for(Login l: lista) {
			senha = l.getSenha();
		}
		
		if(verificador.equals(senha)) {
			System.out.println("Senha correta");
			response.sendRedirect("index.html");
		} else {
			System.out.println("Senha Incorreta.");
			response.sendRedirect("loginRetry.html");
		}
	}

}
