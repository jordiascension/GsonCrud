package com.netmind.dao;

import org.junit.BeforeClass;

public class StudentDaoImplIntegrationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileManagerDao.createFile("alumno.json");
	}

	/*
	 * @AfterClass public static void tearDownAfterClass() throws Exception { }
	 * 
	 * @Before public void setUp() throws Exception { }
	 * 
	 * @After public void tearDown() throws Exception { }
	 * 
	 * @Test public void testAddToJsonFile() throws IOException { StudentDao
	 * studentDao = new StudentDaoImpl();
	 * 
	 * Student student = new Student();
	 * 
	 * studentDao.add(student); fail("Not yet implemented"); }
	 */

}
