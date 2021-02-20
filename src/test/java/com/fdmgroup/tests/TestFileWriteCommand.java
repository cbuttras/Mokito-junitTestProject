package com.fdmgroup.tests;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.UserClasses.User;

import com.fdmgroup.WriteCommand.FileWriteCommand;
import com.fdmgroup.WriteCommand.WriteCommand;
import com.fdmgroup.exceptions.NoEmptyFieldsException;

public class TestFileWriteCommand {

	private String userName = "Christian";
	private String password = "password";
	private String role = "trainee";

	private File file;
	private User user;
	private WriteCommand testFileWriteCommand;

	@Before
	public void setUp() throws Exception {
		file = new File("Demo.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		testFileWriteCommand = new FileWriteCommand(file);
		user = new User(userName, password, role);

	}

	@After
	public void teardown() throws Exception {
		file.delete();

	}

	@Test
	public void test_1_write_one_line_text_into_file() throws Exception {
		// Arrange
		int expectedValue = 1;

		// Act
		testFileWriteCommand.writeUser(user, file);

		// Assert

		FileReader reader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(reader);

		int actualValue = 0;
		String line = null;

		while ((line = bufferedReader.readLine()) != null) {
			actualValue++;

		}
		bufferedReader.close();
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void test_2_write_user_writes_correct_info_in_one_line() throws Exception {

		// Arrange
		String expectedValue = "Christian, password, trainee.";
		// Act
		testFileWriteCommand.writeUser(user, file);
		// Assert

		FileReader reader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(reader);

		String actualValue = bufferedReader.readLine();
		while (bufferedReader.readLine() != null) {
			actualValue = bufferedReader.readLine();
		}
		bufferedReader.close();

		assertEquals(expectedValue, actualValue);

	}

	@Test
	public void test_3_writes_multiple_users_to_file() throws Exception {
		// Arrange

		User user1 = new User("Mohammed", "ghghjk23", "trainer");
		int expectedValue = 2;

		// Act
		testFileWriteCommand.writeUser(user, file);

		testFileWriteCommand.writeUser(user1, file);

		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		int actualValue = 0;

		while ((bufferedReader.readLine()) != null) {
			actualValue++;

		}
		bufferedReader.close();
		assertEquals(expectedValue, actualValue);

	}

	@Test(expected = NoEmptyFieldsException.class)
	public void test_4_need_to_input_informations() throws IOException, NoEmptyFieldsException {
		// Arrange
		User user3 = new User(null, null, null);

		// Act
		testFileWriteCommand.writeUser(user3, file);
		// Assert

	}

}
