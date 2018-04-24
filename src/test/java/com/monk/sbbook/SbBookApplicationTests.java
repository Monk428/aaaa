package com.monk.sbbook;

import com.monk.sbbook.dao.UserDao;
import com.monk.sbbook.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbBookApplicationTests {
	@Autowired
	private UserDao userDao;


	@Test
	public void contextLoads() throws Exception{
//		User user = new User();
//		user.setId(1L);
//		user.setUsername("www2");
//		user.setPassword("1233333");
//		user.setEmail("aaaa");
//		userDao.saveAndFlush(user);

		userDao.updateUsernameById("www4",1L);

//		System.out.print("id："+ userDao.findByUsername("www3").getId());

//		Assert.assertEquals(1, userDao.findAll().size());
	}

}
