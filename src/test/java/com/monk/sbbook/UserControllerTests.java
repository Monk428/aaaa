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
public class UserControllerTests {
	@Autowired
	private UserDao userDao;


	@Test
	public void contextLoads() throws Exception{
		User user = new User();
//		user.setId(1L);
		user.setUsername("www");
		user.setPassword("3333111");
		user.setEmail("ccccc");
		userDao.saveAndFlush(user);

		System.out.println("首次: " + userDao.findByUsername("www"));


		userDao.updateUserName("www5",19L);
		System.out.print("id："+ userDao.findByUsername("www5").get(0).getId());

		//JPA  这种情况，只会创新新的记录
		User user2 = new User();
		user2.setUsername("www5");
		user2.setPassword("1232131");
		user2.setEmail("abcdefg");
		userDao.saveAndFlush(user2);


//		Assert.assertEquals(1, userDao.findAll().size());
	}

}
