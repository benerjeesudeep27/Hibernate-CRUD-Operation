package com.hibernate.revsion.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.hibernate.revsion.entity.Worker;

public class HibrenateUtil {
	static SessionFactory sf;
	static {
		Configuration cfg = null;
		Properties props = new Properties();
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_project");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "Shiva@12345");
		props.put(Environment.HBM2DDL_AUTO, "update");
		props.put(Environment.SHOW_SQL, true);
		props.put(Environment.FORMAT_SQL, true);
		cfg = new Configuration();
		cfg.setProperties(props);
		cfg.addAnnotatedClass(Worker.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry registry = builder.applySettings(cfg.getProperties()).build();
		sf = cfg.buildSessionFactory(registry);
	}

	public static Session createSession() {
		Session session = sf.openSession();
		return session;
	}

	public static void closeSessionFactory(Session session) {
		session.close();
		sf.close();
	}
}
