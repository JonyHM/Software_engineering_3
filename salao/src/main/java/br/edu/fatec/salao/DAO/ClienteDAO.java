package br.edu.fatec.salao.DAO;

import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.Cliente;
import br.edu.fatec.salao.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClienteDAO {
	
	public static ClienteDAO dao;
	
	public static ClienteDAO getInstance() {
		return dao == null 
				? new ClienteDAO()
				: dao;
	}

	@Transactional
	public void salvar(Cliente cliente) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println("---------------------------------------------------");
			System.out.println("Criando cliente: " + cliente.getNome());
			
			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Salvando cliente
			session.save("cliente", cliente);
			
			System.out.println("------------Cliente criado com sucesso!------------");
			transaction.commit();		
		} catch (Exception e) {
			if(transaction != null) {				
				System.out.println("\n...Retornando ao ponto anterior...");
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
	}
	
	public List<Cliente> recuperaClientes() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Cliente", Cliente.class).list();
		}
	}
}
