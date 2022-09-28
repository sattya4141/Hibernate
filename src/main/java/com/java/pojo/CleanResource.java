package com.java.pojo;

import org.hibernate.Session;
import org.hibernate.Transaction;



public class CleanResource {
	
	private CleanResource() {
		
	}

	public static void clenUpResource(Session session, Transaction tr) {
		
		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
		
	}

	
}
