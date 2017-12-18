package biblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.entidades.Funcionario;
import biblio.jdbc.FuncionarioDAO;


@WebServlet("/funccontroller.do")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FuncionarioController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// Obter a Lista - Listar Bibliotecas no Menu
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		List<Funcionario> lista = funcDAO.buscarFuncionarioALL();
		
		// Engavetar no request a Lista
		request.setAttribute("lista", lista);
		
		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listarfuncionarios.jsp");
		saida.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String condicao = request.getParameter("condicao");
		if(condicao.equals("inserir")) {
			// Receber dados da tela
			String nome = request.getParameter("altNomeFuncionario");
			String endereco = request.getParameter("altEnderecoFuncionario");
			String telefone = request.getParameter("altTelefoneFuncionario");
			String salfunc = request.getParameter("altSalarioFuncionario");
			String bibfunc = request.getParameter("altBibliotecaFuncionario");
			// Converter String para Double/Int
			double salario = Double.parseDouble(salfunc);
			int codbib = Integer.parseInt(bibfunc);
			// Criar objeto e atribuir parametros
			Funcionario func = new Funcionario();
			func.setNomefunc(nome);
			func.setEnderecofunc(endereco);
			func.setTelefonefunc(telefone);
			func.setSalario(salario);
			func.setCodbib(codbib);
			
			// Cadastrar no banco de dados
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			funcDAO.cadastrarFuncionario(func);
			
			response.sendRedirect("funccontroller.do");
		} if(condicao.equals("alterar")) {
			// Receber dados da tela
			String codigo = request.getParameter("altCodigoFuncionario");
			String nome = request.getParameter("altNomeFuncionario");
			String endereco = request.getParameter("altEnderecoFuncionario");
			String telefone = request.getParameter("altTelefoneFuncionario");
			String salfunc = request.getParameter("altSalarioFuncionario");
			String bibfunc = request.getParameter("altBibliotecaFuncionario");
			// Converter String para Double/Int
			int codfunc = Integer.parseInt(codigo);
			double salario = Double.parseDouble(salfunc);
			int codbib = Integer.parseInt(bibfunc);
			// Criar objeto e atribuir parametros
			Funcionario func = new Funcionario();
			func.setCodfunc(codfunc);
			func.setNomefunc(nome);
			func.setEnderecofunc(endereco);
			func.setTelefonefunc(telefone);
			func.setSalario(salario);
			func.setCodbib(codbib);
			
			// Alterar no banco de dados
			FuncionarioDAO funcDAO = new FuncionarioDAO();
			funcDAO.alterarFuncionario(func);
			
			response.sendRedirect("funccontroller.do");
		}
		
	}

}
