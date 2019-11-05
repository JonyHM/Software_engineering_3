package br.edu.fatec.salao.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.edu.fatec.salao.model.Bem;
import br.edu.fatec.salao.model.Cliente;
import br.edu.fatec.salao.model.Compra;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	try {
            	Configuration configuration = new Configuration();
            	
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL, "jdbc:h2:./test");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Cliente.class);
//                configuration.addAnnotatedClass(Compra.class);
//                configuration.addAnnotatedClass(Bem.class);
//                
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
