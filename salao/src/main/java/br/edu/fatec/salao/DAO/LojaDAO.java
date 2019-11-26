package br.edu.fatec.salao.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.salao.model.entity.Loja;
import br.edu.fatec.salao.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LojaDAO {

	public static LojaDAO dao;
	
	public static LojaDAO getInstance() {
		return dao == null 
				? new LojaDAO()
				: dao;
	}

	public void salvar(Loja loja) {
		Transaction transaction = null;
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("--------------------------Criando Unidade-------------------------");
			System.out.println(loja.getUnidade());
			
			// Iniciando a Transação
			transaction = session.beginTransaction();
			
			// Salvando Unidade
			session.save(loja);
			
			System.out.println("------------Unidade criada com sucesso!------------");
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
	

	public Loja pegarPorUnidade(String unidade) {
		Loja loja = new Loja();
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			loja = session.createQuery("SELECT DISTINCT l FROM Loja l "
					+ "LEFT JOIN FETCH l.cadastros "
					+ "WHERE l.unidade=:unidade", 
					Loja.class).setParameter("unidade", unidade).getSingleResult();
		} catch (HibernateException e) {
			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}
		
		return loja;
	}

}
