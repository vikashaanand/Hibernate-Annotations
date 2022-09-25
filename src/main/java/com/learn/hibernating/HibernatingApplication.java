package com.learn.hibernating;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatingApplication {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(HibernatingApplication.class, args);

		System.out.println("Application Started : \n");
		
		Configuration conf = new Configuration().configure();

		SessionFactory sessionFactory = conf.buildSessionFactory();

		if (sessionFactory.isOpen()) {

			Session session = sessionFactory.openSession();

			//writeToDB(session);
			
			//readFromDB(session);
			
			writeEmbededToDB(session);

			session.close();

		}
		
		System.out.println("\nApplication Closed");
	}

	private static void writeEmbededToDB(Session session) {
		
		Teacher t1 = new Teacher(111, "Anju", new Qualification("BA", "Ramgargh College"));
		Teacher t2 = new Teacher(112, "Holi", new Qualification("BCOM", "St. Xaviers"));
		
		Transaction transaction = session.beginTransaction();
		
		session.save(t1);
		session.save(t2);
		
		transaction.commit();
		
	}

	private static void readFromDB(Session session) {
		
		System.out.println("\nUsing Load:");
		Teacher teacher1 = (Teacher)session.load(Teacher.class, 103);
		System.out.println(teacher1);
		System.out.println(teacher1.getT_id());
		System.out.println(teacher1.getT_name());
		
		System.out.println("\nUsing Get:");
		Teacher teacher2 = (Teacher)session.get(Teacher.class, 104);
		System.out.println(teacher2);
		System.out.println(teacher2.getT_id());
		System.out.println(teacher2.getT_name());
		
		System.out.println("\nUsing Load, when object not used, QUERY FIRED??:");
		Teacher teacher3 = (Teacher)session.load(Teacher.class, 105);
		
		System.out.println("\nUsing Get, when object not used, QUERY FIRED??:");
		Teacher teacher4 = (Teacher)session.get(Teacher.class, 106);

		
	}

	private static void writeToDB(Session session) throws IOException {
		
		Transaction transaction = session.beginTransaction();

		Teacher t1 = new Teacher(107, "VK");
		Teacher t2 = new Teacher(108, "NN");

		session.save(t1);
		session.save(t2);

		Address add = new Address();
		add.setCity("Ranchi");
		add.setCount(1);
		add.setMetro(false);
		add.setMoveInDate(new Date());

		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream("src/main/resources/img.png");
		byte[] imgByte = new byte[fis.available()];
		fis.read(imgByte);

		add.setImage(imgByte);

		session.save(add);

		transaction.commit();
	}

}
