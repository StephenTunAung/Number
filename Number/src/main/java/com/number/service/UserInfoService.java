package com.number.service;

import java.util.List;

import com.number.model.UserInfo;

public interface UserInfoService {

	void saveUserInfo(UserInfo userInfo);

	void updateUserInfo(UserInfo userInfo);

	UserInfo getUserInfoByEmail(String email);

	UserInfo getUserInfoById(Integer id);

	List<UserInfo> findTopTenUsers();

}
