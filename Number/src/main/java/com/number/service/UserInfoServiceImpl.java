package com.number.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.number.dao.UserInfoDao;
import com.number.model.UserInfo;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public void saveUserInfo(UserInfo userInfo) {
		userInfo.setBestScore(0);
		userInfo.setLastScore(0);
		userInfoDao.saveUserInfo(userInfo);

	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userInfoDao.updateUserInfo(userInfo);

	}

	@Override
	public UserInfo getUserInfoByEmail(String email) {
		return userInfoDao.getUserInfoByEmail(email);
	}

	@Override
	public List<UserInfo> findTopTenUsers() {
		return userInfoDao.findTopTenUsers();
	}

	@Override
	public UserInfo getUserInfoById(Integer id) {
		return userInfoDao.getUserInfoById(id);
	}

}
