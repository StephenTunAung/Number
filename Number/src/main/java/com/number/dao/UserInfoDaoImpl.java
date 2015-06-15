 package com.number.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.number.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUserInfo(UserInfo userInfo) {
		getSession().save(userInfo);

	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		getSession().saveOrUpdate(userInfo);

	}

	@Override
	public UserInfo getUserInfoByEmail(String email) {

		String hql = "from UserInfo where email=:email";

		return (UserInfo) getSession().createQuery(hql)
				.setString("email", email).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findTopTenUsers() {
		String hql = "FROM UserInfo WHERE bestScore>0 ORDER BY bestScore DESC";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(10);
		return query.list();
	}

	@Override
	public UserInfo getUserInfoById(Integer id) {
		return (UserInfo) getSession().get(UserInfo.class, id);
	}

}
