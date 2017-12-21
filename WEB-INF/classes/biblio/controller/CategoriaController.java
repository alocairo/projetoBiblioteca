package biblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.entidades.Categoria;
import biblio.jdbc.CategoriaDAO;

@WebServlet("/catcontroller.do")
public class CategoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CategoriaController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obter a lista
		CategoriaDAO catDAO = new CategoriaDAO();
		List<Categoria> lista = catDAO.buscarCategoriaALL();

		// Engavetar no request a Lista
		request.setAttribute("lista", lista);

		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listarcategoria.jsp");
		saida.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condicao = request.getParameter("condicao");

		if(condicao.equals("inserir")) {
			// Receber dados da tela
			String descricao = request.getParameter("altDescricao");

			// Criar objeto e atribuir elementos
			Categoria cat = new Categoria();
			cat.setDescricao(descricao);

			// Cadastrar no banco de dados
			CategoriaDAO catDAO = new CategoriaDAO();
			catDAO.cadastrarCategoria(cat);

			response.sendRedirect("catcontroller.do");
		} else if (condicao.equals("alterar")) {
			// Receber dados da tela
			String codcat = request.getParameter("altCodigo");
			String descricao = request.getParameter("altDescricao");

			// Converte String para Int
			int codcategoria = Integer.parseInt(codcat);

			// Criar objeto e atribuir elementos
			Categoria cat = new Categoria();
			cat.setCodcategoria(codcategoria);
			cat.setDescricao(descricao);

			// Alterar no banco de dados
			CategoriaDAO catDAO = new CategoriaDAO();
			catDAO.alterarCategoria(cat);

			response.sendRedirect("catcontroller.do");
		}
	}

}
