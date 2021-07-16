package com.example.userTests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.anyString;

import com.example.dao.FileIO;
import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.User;
import com.example.services.UserService;

public class UserServiceTest {

	@InjectMocks
	public UserService uServ;
	
	@Mock
	public UserDao uDao;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testValidLogin() {
		User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(0, "test", "user", "testuser", "test@mail.com", "testpass");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(u1);
		
		User loggedIn = uServ.signIn("testuser", "testpass");
		
		assertEquals(u1.getId(), loggedIn.getId());
	}
	
	@Test(expected = UserDoesNotExistException.class)
	public void testInvalidUsername() {
		User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(0, "test", "user", "testuser", "test@mail.com", "testpass");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(not);
		
		User loggedIn = uServ.signIn("testuser", "testpass");
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void testInvalidPassword() {
		User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
		User not = new User(1, "test", "user", "testuser", "test@mail.com", "wrongpass");
		
		when(uDao.getUserByUsername(anyString())).thenReturn(not);
		
		uServ.signIn("testuser", "testpass");
	}
	
}
