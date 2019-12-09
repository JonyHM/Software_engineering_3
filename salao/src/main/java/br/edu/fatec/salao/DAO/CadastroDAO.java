package br.edu.fatec.salao.DAO;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.entity.Cadastro;
import br.edu.fatec.salao.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CadastroDAO {

	public static CadastroDAO dao;

	public static CadastroDAO getInstance() {
		return dao == null ? new CadastroDAO() : dao;
	}
	
	@Transactional
	public void salvar(Cadastro cadastro) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Criando cadastro--------------------------");
			System.out.println(cadastro);

			// Iniciando a Transação
			transaction = session.beginTransaction();

			// Salvando cliente
			session.save("cadastro", cadastro);

			System.out.println("------------Cadastro criado com sucesso!------------");
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				System.out.println("\n...Retornando ao ponto anterior...");
				transaction.rollback();
			}

			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}
	}
}
