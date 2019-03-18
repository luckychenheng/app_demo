package microResource.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import microResource.dao.UserDAO;
import microResource.model.Info;
import microResource.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Resource
	private HibernateTemplate hibernateTemplate;

	public void save(User u) {
		hibernateTemplate.saveOrUpdate(u);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> getUser(int id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "FROM User u where u.id >" + id;
		Query query = session.createQuery(hql);
		List<User> users = (List<User>) query.list();
		for (User user : users) {
			System.out.println(user);
		}
		return users;
	}

	@Override
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public Info getUserInfo(int id) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "from Info i where i.id = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		Info info = (Info) query.uniqueResult();
		System.out.println(info);
		return info;
	}

}
