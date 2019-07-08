package com.test;

import com.bean.User;
import com.dao.UserDao;

public class Test {

	public static void main(String[] args) {
		User user = new User("test", "test", "test", "test@qq.com");
		System.out.println(UserDao.update(user));
	}

}
