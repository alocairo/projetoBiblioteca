package biblio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblio.jdbc.AlunosDAO;
import biblio.entidades.Alunos;

@WebServlet("/alucontroller.do")
public class AlunosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunosController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Método GET.");
		
		// Obter a lista
		AlunosDAO aluDAO = new AlunosDAO();
		List<Alunos> lista = aluDAO.buscarAlunosALL();
		
		// Engavetar no request a Lista
		request.setAttribute("lista", lista);
		
		// Encaminhamento ao JSP
		RequestDispatcher saida = request.getRequestDispatcher("listaralunos.jsp");
		saida.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando Método POST.");
		String condicao = request.getParameter("condicao");
		if(condicao.equals("inserir")) {
			// Receber dados da tela
			String nome = request.getParameter("altNome");
			String endereco = request.getParameter("altEndereco");
			String situacao = request.getParameter("altSituacao");
			
			// Criar objeto e atribuir os parametros
			Alunos alu = new Alunos();
			alu.setNomealu(nome);
			alu.setEnderecoalu(endereco);
			alu.setSituacaoalu(situacao);
			
			// Cadastrar no banco de dados
			AlunosDAO aluDAO = new AlunosDAO();
			aluDAO.cadastrarAluno(alu);
			
			response.sendRedirect("alucontroller.do");
		} else if(condicao.equals("alterar")) {
			// Receber dados da tela
			String codmat = request.getParameter("altMatricula");
			String nome = request.getParameter("altNome");
			String endereco = request.getParameter("altEndereco");
			String situacao = request.getParameter("altSituacao");
			// Converte String para Int
			int codmatricula = Integer.parseInt(codmat);
			// Criar objeto e atribuir os parametros
			Alunos alu = new Alunos();
			alu.setNomealu(nome);
			alu.setEnderecoalu(endereco);
			alu.setSituacaoalu(situacao);
			alu.setCodmatricula(codmatricula);
			
			// Alterar no banco de dados
			AlunosDAO aluDAO = new AlunosDAO();
			aluDAO.alterarAluno(alu);
			
			response.sendRedirect("alucontroller.do");
		}
	}
}
