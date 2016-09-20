package com.tc.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

import com.tc.model.User;

@Repository("com.tc.dao.LoginDao")
public interface LoginDao extends BaseDAO<User, Integer> {

	User queryUser(Map<String, Object> param) throws Exception;

}
