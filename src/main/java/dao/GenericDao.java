package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
public class GenericDao<PK, T> {
	private static EntityManager entityManager;
	private static EntityManagerFactory factory;

	private final String PERSISTENCE_UNIT_NAME = "ChamadaParlamentar";

	public GenericDao() {
		if (entityManager == null || entityManager.isOpen() == false) {
			if (factory == null || factory.isOpen() == false) {
				factory = Persistence
						.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			} else {
				// nothing to do.
			}

			this.entityManager = factory.createEntityManager();
		} else {
			// nothing to do.
		}
	}

	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public void beginTransaction() {
		if (entityManager.getTransaction().isActive() == false) {
			entityManager.getTransaction().begin();
		}
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	/**
	 * THIS METHOD NEEDS TO BE ALWAYS CALLED
	 */
	public void close() {
		entityManager.close();
		factory.close();
	}

	public void rollBack() {
		entityManager.getTransaction().rollback();
	}
}