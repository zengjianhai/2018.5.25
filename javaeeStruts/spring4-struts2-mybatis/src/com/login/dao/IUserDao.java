package com.login.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {

	Integer findUserByName(String name, String passwd);

}
