package biblio.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.entidades.Alunos;
import biblio.entidades.Empresta;
import biblio.entidades.Livros;
import biblio.jdbc.AlunosDAO;
import biblio.jdbc.EmprestaDAO;
import biblio.jdbc.LivrosDAO;


@WebServlet("/empcontroller.do")
public class EmprestaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmprestaController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Método GET");
		// Obter a lista - Lista de Livros Ativos
		LivrosDAO livDAO = new LivrosDAO();
		List<Livros> listaliv = livDAO.buscarLivrosAtivos();
		
		// Obter a lista - Lista de Alunos Ativos
		AlunosDAO aluDAO = new AlunosDAO();
		List<Alunos> listaalu = aluDAO.buscarAlunosAtivos();		
		
		// Engavetar no request a Lista
		request.setAttribute("listaliv", listaliv); // Lista de Livros
		request.setAttribute("listaalu", listaalu); // Lista de Alunos
		
		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("emprestarlivro.jsp");
		saida.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condicao = request.getParameter("condicao");
		if(condicao.equals("emprestar")) {
			String livro = request.getParameter("altLivro");
			String aluno = request.getParameter("altAluno");
			
			// Converte String para Int
			int codlivro = Integer.parseInt(livro);
			int codaluno = Integer.parseInt(aluno);

			// Criar objeto e atribuir os parametros
			Empresta emp = new Empresta();
			
			emp.setCodlivro(codlivro);
			emp.setCodmatricula(codaluno);
			
			// Registrar no banco de dados
			EmprestaDAO empDAO = new EmprestaDAO();
			try {
				empDAO.Emprestimo(emp);

				PrintWriter saida = response.getWriter();
				saida.print("<script>alert('Livro emprestado!')</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("livcontroller.do");
			
		}
		
	}

}
