package br.edu.fatec.fintech.model.DAO;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.fintech.model.entity.Caixa;
import br.edu.fatec.fintech.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CaixaDAO {

	@Transactional
	public void cadastrar(Caixa caixa) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Criando Caixa--------------------------");
			System.out.println(caixa);

			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Salvando Caixa
			session.save("caixa", caixa);

			System.out.println("------------Caixa criado com sucesso!------------");
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

	@Transactional
	public void atualizar(Caixa caixa) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Atualizando Caixa--------------------------");
			System.out.println(caixa);

			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Atualizando Caixa
			session.update("caixa", caixa);

			System.out.println("------------Caixa Atualizado com sucesso!------------");
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
