package br.edu.fatec.fintech.model.DAO;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.fintech.model.entity.Login;
import br.edu.fatec.fintech.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginDAO {

	@Transactional
	public void cadastrar(Login login) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Criando Login--------------------------");
			System.out.println(login);

			// Iniciando a Transação
			transaction = session.beginTransaction();

			// Salvando Login
			session.save("login", login);

			System.out.println("------------Login criado com sucesso!------------");
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
	
	public Login signIn(String user, String pass) {
		Login login = null;
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			login = session.createQuery("FROM Login l "
					+ "WHERE l.usuario = :user AND l.senha = :pass", 
					Login.class)
						.setParameter("user", user)
						.setParameter("pass", pass)
			.getSingleResult();
			
		} catch (HibernateException hibernate) {
			System.out.println("Erro na Query");
			System.out.println(hibernate.getLocalizedMessage());
		} catch (NoResultException noResult){
			System.out.println("Login ou senha Inválidos");
			System.out.println(noResult.getLocalizedMessage());
		} finally {
			session.close();
		}
		
		return login;
	}
}
