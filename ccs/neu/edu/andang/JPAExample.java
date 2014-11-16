package ccs.neu.edu.andang;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

public class JPAExample {
	public static void main(String args[]) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("openjpa.ConnectionUserName", "root");
		map.put("openjpa.ConnectionPassword", "Thanhcong123#");
		map.put("openjpa.ConnectionURL", "jdbc:mysql://127.0.0.1/hw7");
		map.put("openjpa.ConnectionDriverName", "com.mysql.jdbc.Driver");
        map.put("openjpa.jdbc.SynchronizeMappings", "buildSchema");

   EntityManagerFactory factory = Persistence.createEntityManagerFactory("hw8", map);

    EntityManager em = factory.createEntityManager();
    EntityTransaction userTransaction = em.getTransaction();
		userTransaction.begin();

		// QUESTION !
    List<Box> boxes = em.createQuery(
            "SELECT p FROM Box p").getResultList();

    for(Box box : boxes) {
    	System.out.println(box);
    	for(Containment containment : box.containments) {
    		System.out.println();
    	}
    }    

    userTransaction.commit();
    em.close();
    factory.close();
	}
}
