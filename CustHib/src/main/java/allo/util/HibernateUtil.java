package allo.util;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

public class HibernateUtil {

private static SessionFactory sessionFactory;
private static StandardServiceRegistry registry;

private static SessionFactory getSessionFactory() {
	if(sessionFactory==null) {
		registry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	return sessionFactory;
}



public static Session getSession() {
	return getSessionFactory().openSession();
}


















}
