package com.netmind.business;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.netmind.business.contracts.StudentBl;
import com.netmind.dao.FileManagerDao;
import com.netmind.dao.StudentDaoImpl;
import com.netmind.dao.contracts.StudentDao;
import com.netmind.model.Student;

public class StudentBlImpl implements StudentBl {

	static final Logger logger = Logger.getLogger(StudentBlImpl.class);
	static Properties prop = null;
	static InputStream input = null;

	static {
		prop = new Properties();
		try {
			// https://howtoprogram.xyz/2017/01/17/read-file-and-resource-in-junit-test/
			// Lee el fichero de properties de src/main/resources
			// Si el programa se ejecuta desde el main
			// Lee el fichero de properties de src/test/resources
			// Si el programa se ejecuta desde el test
			input = StudentBlImpl.class
					.getResourceAsStream("/config.properties");
			prop.load(input);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	@Override
	public boolean add(Student student) throws IOException {
		StudentDao studentDao = new StudentDaoImpl();

		student.setAge(calculateAge(student.getDateOfBirth()));

		FileManagerDao.createFile(prop.getProperty("JsonFilename"));
		FileManagerDao.createFile(prop.getProperty("TxtFilename"));
		logger.info(prop.getProperty("TextTxtFileCreated"));
		logger.info(prop.getProperty("TextJsonFileCreated"));

		return studentDao.addStudentToFile(student);
	}

	private int calculateAge(LocalDate dateOfBirth) {
		Period edad = Period.between(dateOfBirth, LocalDate.now());
		return edad.getYears();
	}

	@Override
	public boolean addToJsonFile(Student student) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
}
