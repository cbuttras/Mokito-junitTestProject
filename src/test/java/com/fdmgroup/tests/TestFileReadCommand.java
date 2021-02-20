package com.fdmgroup.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.ReadCommand.FileReadCommand;
import com.fdmgroup.ReadCommand.ReadCommand;
import com.fdmgroup.UserClasses.*;

public class TestFileReadCommand {
	private String userName = "Christian";
	private String password = "password";
	private String role = "trainee";
	private File file;
	private User user;

	private ReadCommand testFileReadCommand;

	@Before
	public void setUp() throws Exception {

		file = new File("Demo2.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		testFileReadCommand = new FileReadCommand(file);
		user = new User(userName, password, role);

	}

	@After
	public void teardown() throws Exception {
		file.delete();
	}

	@Test
	public void test_1_reads_username_correctly() throws IOException {

		// Arrange

		String expectedValue = "Christian";

		// Act
		user = testFileReadCommand.readUser("Christian", file);
		String actualValue = user.getUserName();

		assertEquals(expectedValue, actualValue);

	}

	@Test
	public void test__reads_user_correctly() throws IOException {
		String expectedValue = "[Christian, password, trainee.]";
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);

		bufferedWriter.write("Christian, password, trainee.");

		bufferedWriter.flush();
		bufferedWriter.close();

		user = testFileReadCommand.readUser("Christian", file);
		String[] actualValue = new String[] { user.getUserName(), user.getPassword(), user.getRole() };

		assertEquals(expectedValue, Arrays.toString(actualValue));
	}

	@Test
	public void test__reads_multiple_users_correctly() throws IOException {
		User user2 = new User("Peter", "java8", "trainer");

		String expectedValue = ("[Christian, password, trainee., Peter, java8, trainer]");
		FileWriter writer = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write("Christian, password, trainee.");

		bufferedWriter.newLine();
		bufferedWriter.write("Peter, java8, trainer ");

		bufferedWriter.flush();
		bufferedWriter.close();

		user = testFileReadCommand.readUser("Christian", file);
		String[] actualValue = new String[] { user.getUserName(), user.getPassword(), user.getRole(),
				user2.getUserName(), user2.getPassword(), user2.getRole() };

		assertEquals(expectedValue, Arrays.toString(actualValue));
	}

}
