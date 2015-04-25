package edu.neu.aarambh.DAO;
import java.sql.Date;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.aarambh.classes.*;

public class DAOUser {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cs5200Project");
	EntityManager em = factory.createEntityManager();
	
	//inserting in the table
	public void insertNewUser(String username, String password, String firstname, String lastname ,Date date, Integer phno, String email)
	{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setDob(date);
		user.setPhnumber(phno);
		user.setEmail(email);
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		}
	
	public boolean findUser(String username ,String password)
	{
		em.getTransaction().begin();
		User user = em.find(User.class, username);
		em.getTransaction().commit();
		if ( (user != null) &&
				(password.equals(user.getPassword())))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void updateUser(String username, String password, String firstname, String lastname ,Date date, Integer phno, String email)
	{
		User user = em.find(User.class, username);
		user.setPassword(password);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setDob(date);
		user.setPhnumber(phno);
		user.setEmail(email);
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}
	
public static void main(String[] args) {
		
		DAOUser user = new DAOUser();
		Date sqlDate = new Date(19900303);
	   sqlDate = new java.sql.Date(sqlDate.getTime());
		user.insertNewUser("kumar", "32", "roop", "kumar", sqlDate , 900, "adasd@gmial.com");
		DAOUser user1 = new DAOUser();
		user1.findUser("kumar","123");
}
	
}

