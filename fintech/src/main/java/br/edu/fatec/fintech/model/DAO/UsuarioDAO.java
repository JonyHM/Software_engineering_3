package br.edu.fatec.fintech.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.fatec.fintech.model.entity.Caixa;
import br.edu.fatec.fintech.model.entity.Movimentacao;
import br.edu.fatec.fintech.model.entity.Usuario;
import br.edu.fatec.fintech.model.enums.Classificacao;
import br.edu.fatec.fintech.util.HibernateUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioDAO {

	@Transactional
	public void cadastrar(Usuario usuario) {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			System.out.println("-------------------------Criando Usuario--------------------------");
			System.out.println(usuario);

			// Iniciando a Transação
			transaction = session.beginTransaction();

			// Salvando usuario
			session.save("usuario", usuario);

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
	
	public List<Usuario> listaUsuarios() {
		List<Usuario> clientes = new ArrayList<Usuario>();
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			clientes = session.createQuery("SELECT DISTINCT u FROM Usuario u "
					+ "LEFT JOIN FETCH u.login LEFT JOIN FETCH u.caixa "
					+ "ORDER BY u.nome ASC", 
					Usuario.class).getResultList();
		} catch (HibernateException e) {
			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}
		
		return clientes;
	}
	
	public List<Movimentacao> listaMovimentacoes() {
		List<Movimentacao> movimentacoes = new ArrayList<>();
		List<Movimentacao> entradas = new ArrayList<>();
		List<Movimentacao> saidas = new ArrayList<>();
		Caixa caixa = new Caixa();
		
		Session session = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			caixa = session.createQuery("SELECT u.caixa FROM Usuario u "
					+ "LEFT JOIN u.caixa c "
					+ "LEFT JOIN c.entradas e "
					+ "LEFT JOIN c.saidas s", 
					Caixa.class).getSingleResult();
		} catch (HibernateException e) {
			e.getCause().getLocalizedMessage();
		} finally {
			session.close();
		}
		
		caixa.getEntradas().forEach(e -> {
			if (e.getClassificacao() == Classificacao.ENTRADA) {
				entradas.add(e);
			}
		});
		caixa.getSaidas().forEach(s -> {
			if (s.getClassificacao() == Classificacao.SAIDA) {
				saidas.add(s);
			}
		});
		
		movimentacoes.addAll(entradas);
		movimentacoes.addAll(saidas);
		
		return movimentacoes;
	}
}
