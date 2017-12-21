package biblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.entidades.Biblioteca;
import biblio.jdbc.BibliotecaDAO;

@WebServlet("/bibcontroller.do")
public class BibliotecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public BibliotecaController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obter a Lista - Listar Bibliotecas no Menu
		BibliotecaDAO bibDAO = new BibliotecaDAO();
		List<Biblioteca> lista = bibDAO.buscarBibliotecaALL();

		// Engavetar no request a Lista
		request.setAttribute("lista", lista);

		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listarbibliotecas.jsp");
		saida.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condicao = request.getParameter("condicao");

		if(condicao.equals("inserir")) {
			// Receber dados da tela
			String nome = request.getParameter("altNome");
			String endereco = request.getParameter("altEndereco");

			// Criar objeto e atribuir parametros
			Biblioteca bib = new Biblioteca();
			bib.setNomebib(nome);
			bib.setEnderecobib(endereco);

			// Cadastrar no banco de dados
			BibliotecaDAO bibDAO = new BibliotecaDAO();
			bibDAO.cadastrarBiblioteca(bib);

			response.sendRedirect("bibcontroller.do");
		} else if(condicao.equals("alterar")) {
			// Receber dados da tela
			String codbiblioteca = request.getParameter("altCodigo");
			String nome = request.getParameter("altNome");
			String endereco = request.getParameter("altEndereco");
			// Converte String para int
			int codbib = Integer.parseInt(codbiblioteca);
			// Criar objeto e atribuir parametros
			Biblioteca bib = new Biblioteca();
			bib.setCodbib(codbib);
			bib.setNomebib(nome);
			bib.setEnderecobib(endereco);

			// Alterar no banco de dados
			BibliotecaDAO bibDAO = new BibliotecaDAO();
			bibDAO.alterarBiblioteca(bib);

			response.sendRedirect("bibcontroller.do");
		}
	}

}
