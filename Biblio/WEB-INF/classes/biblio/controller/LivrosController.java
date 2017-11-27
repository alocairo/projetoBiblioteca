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
import biblio.entidades.Categoria;
import biblio.entidades.Livros;
import biblio.jdbc.BibliotecaDAO;
import biblio.jdbc.CategoriaDAO;
import biblio.jdbc.LivrosDAO;


@WebServlet("/livcontroller.do")
public class LivrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LivrosController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Método GET");
		
		// Obter a lista
		LivrosDAO livDAO = new LivrosDAO();
		List<Livros> listaliv = livDAO.buscarLivrosALL();

		// Obter a Lista - Listar Bibliotecas no Menu
		BibliotecaDAO bibDAO = new BibliotecaDAO();
		List<Biblioteca> listabib = bibDAO.buscarBibliotecaALL();
					
		// Obter a Lista - Listar Categorias no Menu
		CategoriaDAO catDAO = new CategoriaDAO();
		List<Categoria> listacat = catDAO.buscarCategoriaALL();
		
				
		// Engavetar no request a Lista
		request.setAttribute("listaliv", listaliv); // Lista de Livros
		request.setAttribute("listabib", listabib); // Lista de Bibliotecas (Menu)
		request.setAttribute("listacat", listacat); // Lista de Categorias (Menu)
		
		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listarlivros.jsp");
		saida.forward(request, response);
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Método POST");
		
		String condicao = request.getParameter("condicao");
		if(condicao.equals("inserir")) {
			// Receber dados da tela
			String titulo = request.getParameter("altTituloLivro");
			String editora = request.getParameter("altEditoraLivro");
			String valorliv = request.getParameter("altValorLivro");
			String catliv = request.getParameter("altCategoria");
			String bibliv = request.getParameter("altBiblioteca");
			String situacao = request.getParameter("altSituacao");
			
			// Converter String para Double/Int
			double valor = Double.parseDouble(valorliv);
			int codcat = Integer.parseInt(catliv);
			int codbib = Integer.parseInt(bibliv);
			
			// Criar objeto e atribuir parametros
			Livros liv = new Livros();
			liv.setTitulo(titulo);
			liv.setEditora(editora);
			liv.setValor(valor);
			liv.setCodcategoria(codcat);
			liv.setCodbib(codbib);
			liv.setSituacaoliv(situacao);
			
			// Cadastrar no banco de dados
			LivrosDAO livDAO = new LivrosDAO();
			livDAO.cadastrarLivro(liv);
			
			response.sendRedirect("livcontroller.do");
		} else if(condicao.equals("alterar")) {
			// Receber dados da tela
			String codigo = request.getParameter("altCodigoLivro");
			String titulo = request.getParameter("altTituloLivro");
			String editora = request.getParameter("altEditoraLivro");
			String valorliv = request.getParameter("altValorLivro");
			String catliv = request.getParameter("altCategoria");
			String bibliv = request.getParameter("altBiblioteca");
			String situacao = request.getParameter("altSituacao");
			
			// Converter String para Double/Int
			int codliv = Integer.parseInt(codigo);
			double valor = Double.parseDouble(valorliv);
			int codcat = Integer.parseInt(catliv);
			int codbib = Integer.parseInt(bibliv);
			
			// Criar objeto e atribuir parametros
			Livros liv = new Livros();
			liv.setCodlivro(codliv);
			liv.setTitulo(titulo);
			liv.setEditora(editora);
			liv.setValor(valor);
			liv.setCodcategoria(codcat);
			liv.setCodbib(codbib);
			liv.setSituacaoliv(situacao);
			
			// Alterar no banco de dados
			LivrosDAO livDAO = new LivrosDAO();
			livDAO.alterarLivro(liv);
			
			response.sendRedirect("livcontroller.do"); 
		}
		
	}

}
