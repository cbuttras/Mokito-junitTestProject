package com.fdmgroup.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.UserClasses.User;
import com.fdmgroup.UserClasses.UserFactory;

import com.fdmgroup.exceptions.NoEmptyFieldsException;

public class UserfactoryTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test_user_factory_creates_user() throws IOException, NoEmptyFieldsException {
		// Arrange
		UserFactory userFactory = new UserFactory();

		String expectedValue = "[null, null, null]";

		// Act
		User user = userFactory.createUser();

		String[] actualValue = new String[] { user.getUserName(), user.getPassword(), user.getRole() };

		assertEquals(expectedValue, Arrays.toString(actualValue));

	}

}
