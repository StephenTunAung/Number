package com.number.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6430534924249006191L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "LAST_SCORE")
	private Integer lastScore;

	@Column(name = "BEST_SCORE")
	private Integer bestScore;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLastScore() {
		return lastScore;
	}

	public void setLastScore(Integer lastScore) {
		this.lastScore = lastScore;
	}

	public Integer getBestScore() {
		return bestScore;
	}

	public void setBestScore(Integer bestScore) {
		this.bestScore = bestScore;
	}

}
