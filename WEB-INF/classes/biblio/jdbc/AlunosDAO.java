package biblio.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblio.entidades.Alunos;

public class AlunosDAO {
	private Connection con = Conexao.getConnection();

	public void cadastrarAluno (Alunos alunos) { // insere aluno no banco de dados
		// SQL
		String sql = "INSERT INTO ALUNOS (nome, endereco, situacao) VALUES (?, ?, ?)"; // AUTO INCREMENT FUNCIONA ADICIONAR CODMATRICULA COMO SERIAL

		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, alunos.getNomealu());
			preparador.setString(2, alunos.getEnderecoalu());
			preparador.setString(3, alunos.getSituacaoalu());

			preparador.execute();
			preparador.close();

			System.out.println("Aluno cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarAluno (Alunos alunos) { // Altera os dados do aluno no banco de dados
		// SQL
		String sql = "UPDATE ALUNOS SET nome=?, endereco=?, situacao=? WHERE codmatricula=?;";

		// PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, alunos.getNomealu());
			preparador.setString(2, alunos.getEnderecoalu());
			preparador.setString(3, alunos.getSituacaoalu());
			preparador.setInt(4, alunos.getCodmatricula());

			preparador.execute();
			preparador.close();

			System.out.println("Aluno alterado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Alunos> buscarAlunosALL() {
		// Monta SQL
		String sql = "SELECT * FROM ALUNOS";

		List<Alunos> lista = new ArrayList<Alunos>();

		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){

				Alunos alu = new Alunos();

				alu.setCodmatricula(resultado.getInt("codmatricula"));
				alu.setNomealu(resultado.getString("nome"));
				alu.setEnderecoalu(resultado.getString("endereco"));
				alu.setSituacaoalu(resultado.getString("situacao"));

				lista.add(alu);

			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public List<Alunos> buscarAlunosAtivos() {
		// Monta SQL
		String sql = "SELECT * FROM ALUNOS WHERE SITUACAO='Habilitado'";

		List<Alunos> lista = new ArrayList<Alunos>();

		// Constroi o PreparedStatement com o SQL
		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while(resultado.next()){

				Alunos alu = new Alunos();

				alu.setCodmatricula(resultado.getInt("codmatricula"));
				alu.setNomealu(resultado.getString("nome"));
				alu.setEnderecoalu(resultado.getString("endereco"));
				alu.setSituacaoalu(resultado.getString("situacao"));

				lista.add(alu);

			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

}
