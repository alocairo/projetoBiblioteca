package biblio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.entidades.Empresta;
import biblio.entidades.Livros;
import biblio.jdbc.EmprestaDAO;
import biblio.jdbc.LivrosDAO;

@WebServlet("/devcontroller.do")
public class DevolveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DevolveController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Método GET");
		// Obter a lista - Lista de Livros Emprestados
		LivrosDAO livDAO = new LivrosDAO();
		List<Livros> lista = livDAO.buscarLivrosEmprestados();
		
		// Engavetar no request a Lista
		request.setAttribute("lista", lista); // Lista de Livros
		
		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("devolverlivro.jsp");
		saida.forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condicao = request.getParameter("condicao");
		if(condicao.equals("devolver")) {
			String livro = request.getParameter("altLivro");

			// Converte String para Int
			int codlivro = Integer.parseInt(livro);
			
			// Criar objeto e atribuir os parametros
			Empresta emp = new Empresta();
			emp.setCodlivro(codlivro);
			
			// Registrar no banco de dados
			EmprestaDAO empDAO = new EmprestaDAO();
			PrintWriter saida = response.getWriter();
			saida.print("<script>alert('Livro devolvido!')</script>");
			try {
				empDAO.DevolverLivro(emp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("livcontroller.do");
			
		}
	}

}
