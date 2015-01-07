package org.hamster.server.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hamster.server.db.entities.AbstractEntity;
import org.hamster.shared.dto.AbstractDTO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Utils {
	 private static final SessionFactory sessionFactory;
	 
	 
	 
	    static {
	        try {
	        	Configuration configuration = new Configuration().configure(
	        			new File("D:/JavaProjects/University/src/org/hamster/server/db/hibernate.cfg.xml"));
	        	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
	        	applySettings(configuration.getProperties());
	        	sessionFactory = configuration.buildSessionFactory(builder.build());
	        
	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    @SuppressWarnings("unchecked")
		public static <T extends AbstractEntity, R extends AbstractDTO> List<R> convertEntityToDTOList(List<T> listEntity)
	    {
	    	List<R> listDTO = new ArrayList<R>();
			for(AbstractEntity entity: listEntity)
			{
				listDTO.add((R)entity.convertToDTO());
			}
			return listDTO;
	    }
	    
	   
}
	    
	  

