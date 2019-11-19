package br.edu.fatec.salao.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.entity.Cliente;
import br.edu.fatec.salao.model.enums.Genero;
import br.edu.fatec.salao.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClienteDAO {

	public static ClienteDAO dao;

	public static ClienteDAO getInstance() {
		return dao == null ? new ClienteDAO() : dao;
	}

	@Transactional
	public void salvar(Cliente cliente) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Criando cliente--------------------------");
			System.out.println(cliente);

			// Iniciando a Transação
			transaction = session.beginTransaction();

			// Salvando cliente
			session.save("cliente", cliente);

			System.out.println("------------Cliente criado com sucesso!------------");
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

	public List<Cliente> recuperaClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			clientes = session.createQuery("SELECT DISTINCT c FROM Cliente c LEFT JOIN FETCH c.compras ORDER BY c.nome ASC", 
					Cliente.class).getResultList();
		} catch (HibernateException e) {
			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}
		
		return clientes;
	}

	public List<Cliente> listarPorGenero(Genero genero) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			clientes = session.createQuery(
					"SELECT DISTINCT c FROM Cliente c LEFT JOIN FETCH c.compras WHERE c.genero=:genero ORDER BY c.nome ASC",
					Cliente.class).setParameter("genero", genero).getResultList();
		} catch (HibernateException e) {
			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}
		
		return clientes;
	}

	@Transactional
	public void editar(Cliente cliente) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("---------------------------Atualizando cliente------------------------");
			System.out.println(cliente.getNome());

			// Iniciando a Transação
			transaction = session.beginTransaction();

			session.update("cliente", cliente);

			System.out.println("------------Cliente atualizado com sucesso!------------");
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

	public Cliente procuraPorId(long id) {
		Cliente cli = new Cliente();
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
					
			// Procurando cliente por ID
			cli = session.find(Cliente.class, id);

		} catch (HibernateException e) {
			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}

		return cli;
	}

	@Transactional
	public void excluir(Cliente cliente) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
					
			System.out.println("-----------------------Excluindo cliente----------------------------");
			System.out.println(cliente.getNome());

			// Iniciando a Transação
			transaction = session.beginTransaction();

			session.delete("cliente", cliente);

			System.out.println("------------Cliente excluído com sucesso!------------");
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
