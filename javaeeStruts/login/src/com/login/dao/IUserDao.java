package com.login.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

	int findUserByName(String name, String passwd);

}
