package br.edu.fatec.salao.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.edu.fatec.salao.model.entity.Bem;
import br.edu.fatec.salao.model.entity.Cadastro;
import br.edu.fatec.salao.model.entity.Cliente;
import br.edu.fatec.salao.model.entity.Compra;
import br.edu.fatec.salao.model.entity.Loja;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	try {
            	Configuration configuration = new Configuration();
            	
                // Configurações do Hibernate que substituem o arquivo hibernate.cfg.xml
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:./db/contatos");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                settings.put(Environment.JDBC_TIME_ZONE, "UTC");
//                settings.put(Environment.SHOW_SQL, "true");
//                settings.put(Environment.FORMAT_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.C3P0_MAX_SIZE, 100);
                settings.put(Environment.C3P0_MIN_SIZE, 1);
                settings.put(Environment.C3P0_ACQUIRE_INCREMENT, 2);
                settings.put(Environment.C3P0_MAX_STATEMENTS, 1000);
                settings.put(Environment.C3P0_TIMEOUT, 7200);
                
                configuration.setProperties(settings);
                
                configuration.addAnnotatedClass(Bem.class);
                configuration.addAnnotatedClass(Compra.class);
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(Loja.class);
                configuration.addAnnotatedClass(Cadastro.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                		.applySettings(
                				configuration.getProperties())
                		.build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return sessionFactory;
    }
}
