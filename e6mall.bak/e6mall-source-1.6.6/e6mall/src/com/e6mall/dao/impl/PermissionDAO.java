package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.IPermissionDAO;
import com.e6mall.model.Permission;

/**
 * A data access object (DAO) providing persistence and search support for
 * Msetting entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Permission
 * @author bingzhou6@gmail.com
 */

public class PermissionDAO extends BaseDAO implements IPermissionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PermissionDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Permission transientInstance) {
		log.debug("saving Permission instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Permission persistentInstance) {
		log.debug("deleting Permission instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Permission findById(java.lang.String id) {
		log.debug("getting Permission instance with id: " + id);
		try {
			Permission instance = (Permission) getHibernateTemplate().get(
					"com.e6mall.model.Permission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Permission instance) {
		log.debug("finding Permission instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Permission instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Permission as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List findByRead(Object read) {
		return findByProperty(READ, read);
	}

	public List findByWrite(Object write) {
		return findByProperty(WRITE, write);
	}
	
	public List findByDelete(Object delete) {
		return findByProperty(DELETE, delete);
	}

	public List findAll() {
		log.debug("finding all Permission instances");
		try {
			String queryString = "from Permission";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Permission merge(Permission detachedInstance) {
		log.debug("merging Permission instance");
		try {
			Permission result = (Permission) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Permission instance) {
		log.debug("attaching dirty Permission instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Permission instance) {
		log.debug("attaching clean Permission instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IPermissionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IPermissionDAO) ctx.getBean("PermissionDAO");
	}
}