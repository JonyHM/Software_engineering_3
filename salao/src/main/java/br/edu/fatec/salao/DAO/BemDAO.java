package br.edu.fatec.salao.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.entity.Bem;
import br.edu.fatec.salao.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BemDAO {

	public static BemDAO dao;
	
	public static BemDAO getInstance() {
		return dao == null 
				? new BemDAO()
				: dao;
	}

	public void salvar(Bem bem) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
					
			System.out.println("---------------------Criando bem------------------------------");
			System.out.println(bem);
			
			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Salvando compra
			session.save(bem);
			
			System.out.println("------------Bem criado com sucesso!------------");
			transaction.commit();		
		} catch (Exception e) {
			if(transaction != null) {				
				System.out.println("\n...Retornando ao ponto anterior...");
				transaction.rollback();
			}
			
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public List<Bem> recuperaBens() {
		List<Bem> bens = new ArrayList<Bem>();
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			bens = session.createQuery("from Bem", Bem.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return bens; 
	}
	
}
