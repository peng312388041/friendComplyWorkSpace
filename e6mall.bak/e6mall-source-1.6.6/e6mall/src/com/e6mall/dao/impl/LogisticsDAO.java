package com.e6mall.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.e6mall.dao.ILogisticsDAO;
import com.e6mall.model.Logistics;

/**
 * A data access object (DAO) providing persistence and search support for
 * Logistics entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.e6mall.model.Logistics
 * @author bingzhou6@gmail.com
 */

public class LogisticsDAO extends BaseDAO implements ILogisticsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LogisticsDAO.class);
	protected void initDao() {
		// do nothing
	}

	public void save(Logistics transientInstance) {
		log.debug("saving Logistics instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Logistics persistentInstance) {
		log.debug("deleting Logistics instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Logistics findById(java.lang.String id) {
		log.debug("getting Logistics instance with id: " + id);
		try {
			Logistics instance = (Logistics) getHibernateTemplate().get(
					"com.e6mall.model.Logistics", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Logistics instance) {
		log.debug("finding Logistics instance by example");
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
		log.debug("finding Logistics instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Logistics as model where model."
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

	public List findByIntro(Object intro) {
		return findByProperty(INTRO, intro);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByPourl(Object pourl) {
		return findByProperty(POURL, pourl);
	}

	public List findByCsort(Object csort) {
		return findByProperty(CSORT, csort);
	}

	public List findAll() {
		log.debug("finding all Logistics instances");
		try {
			String queryString = "from Logistics";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Logistics merge(Logistics detachedInstance) {
		log.debug("merging Logistics instance");
		try {
			Logistics result = (Logistics) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Logistics instance) {
		log.debug("attaching dirty Logistics instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Logistics instance) {
		log.debug("attaching clean Logistics instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ILogisticsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ILogisticsDAO) ctx.getBean("LogisticsDAO");
	}
}