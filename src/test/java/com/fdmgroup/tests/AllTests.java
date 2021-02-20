package com.fdmgroup.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFileReadCommand.class, TestFileWriteCommand.class, UserfactoryTest.class,
		TestRegistrationController.class })
public class AllTests {

}
