package br.edu.fatec.salao.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.Compra;
import br.edu.fatec.salao.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CompraDAO {

	public static CompraDAO dao;
	
	public static CompraDAO getInstance() {
		return dao == null 
				? new CompraDAO()
				: dao;
	}

	public void salvar(Compra compra) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println("---------------------------------------------------");
			System.out.println("Criando compra");
			
			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Salvando compra
			session.save(compra);
			
			System.out.println("------------Compra criada com sucesso!------------");
			transaction.commit();		
		} catch (Exception e) {
			if(transaction != null) {				
				System.out.println("\n...Retornando ao ponto anterior...");
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
	}
	
	public List<Compra> recuperaCompras() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from compra", Compra.class).list();
		}
	}
}
