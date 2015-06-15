package com.number.dao;

import java.util.List;

import com.number.model.UserInfo;

public interface UserInfoDao {

	void saveUserInfo(UserInfo userInfo);

	void updateUserInfo(UserInfo userInfo);

	UserInfo getUserInfoByEmail(String email);

	UserInfo getUserInfoById(Integer id);

	List<UserInfo> findTopTenUsers();

}
