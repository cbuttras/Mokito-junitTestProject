package com.fdmgroup.tests;

import static org.mockito.Mockito.times;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.ReadCommand.FileReadCommand;

import com.fdmgroup.RegistrationController.RegistrationController;
import com.fdmgroup.UserClasses.User;
import com.fdmgroup.UserClasses.UserFactory;
import com.fdmgroup.WriteCommand.FileWriteCommand;
import com.fdmgroup.exceptions.NoDuplicatesAllowedException;
import com.fdmgroup.exceptions.NoEmptyFieldsException;

public class TestRegistrationController {
	private File file;

	private RegistrationController registrationController;

	@Mock
	private FileReadCommand mockFileReadCommand;
	@Mock
	private FileWriteCommand mockFileWriteCommand;
	@Mock
	private UserFactory mockUserFactory;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		file = new File("Demo.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		registrationController = new RegistrationController(mockFileReadCommand, mockFileWriteCommand, mockUserFactory);

	}

	@After
	public void teardown() throws Exception {
		file.delete();

	}

	@Test
	public void test_register_new_user_calls_user_factory()
			throws IOException, NoEmptyFieldsException, NoDuplicatesAllowedException {
		User user1 = new User("Travis", "password", "trainee");
		Mockito.when(mockFileReadCommand.readUser("Travis", file))
				.thenReturn(new User("Travis", "password", "trainee"));
		Mockito.when(mockUserFactory.createUser()).thenReturn(user1);
		registrationController.registerNewUser("Travis", "password", "trainee");
		Mockito.verify(mockUserFactory, times(1)).createUser();

	}

	@Test
	public void test_register_new_user_calls_read_command()
			throws IOException, NoEmptyFieldsException, NoDuplicatesAllowedException {
		User user2 = new User("David", "password", "trainee");
		Mockito.when(mockFileReadCommand.readUser("David", file)).thenReturn(user2);
		Mockito.when(mockUserFactory.createUser()).thenReturn(user2);
		registrationController.registerNewUser("David", "password", "trainee");
		Mockito.verify(mockFileReadCommand, times(1)).readUser("David", file);
	}

	@Test
	public void test_register_new_user_calls_write_command()
			throws IOException, NoEmptyFieldsException, NoDuplicatesAllowedException {
		User user3 = new User("Mohammed", "password", "trainer");
		Mockito.when(mockFileReadCommand.readUser("Mohammed", file))
				.thenReturn(new User("Mohammed", "password", "trainer"));
		Mockito.when(mockUserFactory.createUser()).thenReturn(user3);
		registrationController.registerNewUser("Mohammed", "password", "trainer");
		Mockito.verify(mockFileWriteCommand, times(1)).writeUser(user3, file);
	}

	@Test(expected = NoDuplicatesAllowedException.class)
	public void test_ensures_no_duplicates() throws IOException, NoEmptyFieldsException, NoDuplicatesAllowedException {
		User user1 = new User("Travis", "password", "trainee");
		Mockito.when(mockFileReadCommand.readUser("David", file)).thenReturn(new User("David", "password", "trainee"));

		Mockito.when(mockUserFactory.createUser()).thenReturn(user1);
		registrationController.registerNewUser("Travis", "password", "trainee");
		Mockito.verify(mockUserFactory, times(1)).createUser();
	}
}
