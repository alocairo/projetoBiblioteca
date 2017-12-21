package biblio.teste;

import java.text.ParseException;
import java.util.List;

import biblio.entidades.Empresta;
import biblio.entidades.Livros;
import biblio.jdbc.EmprestaDAO;
import biblio.jdbc.LivrosDAO;

public class TesteAlunosDAO {

	public static void main(String[] args) throws Exception {
		/*
		EmprestaDAO empDAO = new EmprestaDAO();

		List<Empresta> verifica = empDAO.ListarEmprestimo();

		for (Empresta e: verifica) {
			try {
				empDAO.VerificarAluno(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 */
		/*
		Livros liv = new Livros();
		LivrosDAO livDAO = new LivrosDAO();

		liv.setCodlivro(2);
		//System.out.println(livDAO.PrevisaoLivro(liv));
		*/
		/*


		 * Calendar data1 = Calendar.getInstance();
Calendar data2 = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
data1.setTime(sdf.parse("01/06/2007"));
data2.setTime(new Date());
int inicio = data1.get(Calendar.DAY_OF_YEAR);
int fim = data2.get(Calendar.DAY_OF_YEAR);
int qdeDias = (fim - inicio) + 1;
for (; inicio <= fim; inicio++){
    if (data1.get(Calendar.DAY_OF_WEEK) == 1
        || data1.get(Calendar.DAY_OF_WEEK) == 7)
	qdeDias--;
    data1.add(Calendar.DATE, 1);
}
*/



		/*
		Date dia = new Date();
		String data = null;
		Calendar c = Calendar.getInstance();
		c.setTime(dia);

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

		c.add(Calendar.DAY_OF_YEAR, 2);
		System.out.println("Data: " + df.format(c.getTime()));

		data = df.format(c.getTime());

		System.out.println("String: " + data);

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		try {
			d = df.parse("28/11/2017");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		System.out.println(df.format(d));

		String dateString = null;

		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DAY_OF_YEAR, 12);
		d = c.getTime();

		try{
			dateString = df.format(d);
		} catch (Exception ex) {
			System.out.println(ex);
		}


		System.out.println(dateString);
		*/
	}

}
