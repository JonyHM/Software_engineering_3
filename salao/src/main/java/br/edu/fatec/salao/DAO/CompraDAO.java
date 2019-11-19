package br.edu.fatec.salao.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.entity.Compra;
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
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();			
			System.out.println("--------------------------Criando compra-------------------------");
			System.out.println("Cliente: " + compra.getCliente());
			
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
		} finally {
			session.close();
		}
	}
	
	public List<Compra> recuperaCompras() {
		List<Compra> compras = new ArrayList<Compra>(); 
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Compras Encontradas");
			compras = session.createQuery("SELECT DISTINCT c FROM Compra c LEFT JOIN FETCH c.bens ORDER BY c.data ASC", Compra.class).list();
		} catch (Exception e) {
			System.out.println("Nenhuma Compra Encontrada");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return compras; 
	}
}
