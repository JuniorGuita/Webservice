package br.edu.fjn.ws.dao;

import javax.persistence.EntityManager;
import br.edu.fjn.ws.connection.Connection;
import br.edu.fjn.ws.model.Supervisor;

public class SupervisorDAO {
	public void insert(Supervisor supervisor) {
		EntityManager manager = Connection.getConnection();
		manager.getTransaction().begin();
		try {
			manager.persist(supervisor);
			manager.getTransaction().commit();
		} catch (NullPointerException nullPointerException) {
			manager.getTransaction().rollback();
		} catch (Exception exception) {
			manager.getTransaction().rollback();
		} finally {
			manager.clear();
			manager.close();
		}
	}
}
