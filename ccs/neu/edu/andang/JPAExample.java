package ccs.neu.edu.andang;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

public class JPAExample {
	public static void main(String args[]) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("openjpa.ConnectionUserName", "***Fill in Yours***");
		map.put("openjpa.ConnectionPassword", "***Fill in Yours***");
		map.put("openjpa.ConnectionURL", "***Fill in Yours***");
		map.put("openjpa.ConnectionDriverName", "com.mysql.jdbc.Driver");

   EntityManagerFactory factory = Persistence.createEntityManagerFactory("hw8", map);

    EntityManager em = factory.createEntityManager();
    EntityTransaction userTransaction = em.getTransaction();
		userTransaction.begin();

		/* QUESTION 1
		  Which boxes contain a collection of items that exceeds the total volume limitation
		  or maximum weight limitation?
		 */
    List<Box> boxes = em.createQuery(
            "SELECT p FROM BOX p").getResultList();

    for(Box box : boxes) {
    	System.out.println(box);
	    Double maxWeight = box.getMaximumWeight();
	    Double maxVolumn = box.getVolume();
			Double currentWeight = 0.0;
	    Double currentVolume = 0.0;

	    System.out.println("Fullfills: " + box.getInvoice());

	    for(Containment containment : box.getContainments()) {
		    currentWeight += containment.getProduct().getWeight() * containment.getCount();
		    currentVolume += containment.getProduct().getVolume() * containment.getCount();

		    if(currentVolume > maxVolumn || currentWeight > maxWeight) {
			    System.out.println("Bad box: " + box);
		    }
	    }
    }

		/* QUESTION 2
		  Which invoices have not been correctly fulfilled?
		 */
		List<Invoice> invoices = em.createQuery(
				"SELECT p FROM INVOICE p").getResultList();

		for(Invoice invoice : invoices) {
			System.out.println(invoice);

			// Strategy: get all boxes that fulfills the current invoice
			// then check if those boxes have all items that the invoice requires
			Collection<Box> boxesThatFulfillInvoice = invoice.getBoxes();

			for(Containment containment : invoice.getContainments()) {
				int count = containment.getCount();
				int totalCount = findNumberOfProducts(boxesThatFulfillInvoice, containment.getProduct());
				if(count != totalCount) {
					System.out.println("Bad invoice: " + invoice);
				}
			}
		}

		userTransaction.commit();
    em.close();
    factory.close();
	}

	private static int findNumberOfProducts(Collection<Box> boxes, Product product) {
		int count = 0;
		for(Box box: boxes) {
			for (Containment containment : box.getContainments()) {
				if (containment.getProduct().equals(product)) {
					count += containment. getCount();
				}
			}
		}
		return count;
	}
}
