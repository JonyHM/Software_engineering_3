package br.edu.fatec.fintech.model.DAO;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.fintech.model.entity.Movimentacao;
import br.edu.fatec.fintech.util.HibernateUtil;

public class MovimentacaoDAO {

	@Transactional
	public void cadastrar(Movimentacao movimentacao) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Criando Movimentacao--------------------------");
			System.out.println(movimentacao);

			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Salvando Movimentacao
			session.save("movimentacao", movimentacao);

			System.out.println("------------Movimentacao criado com sucesso!------------");
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
