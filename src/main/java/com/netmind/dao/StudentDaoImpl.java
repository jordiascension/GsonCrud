package com.netmind.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.netmind.common.model.Student;
import com.netmind.dao.contracts.StudentDao;

public class StudentDaoImpl implements StudentDao {

	private static ArrayList<Student> studentList = null;
	static final Logger logger = Logger.getLogger(StudentDaoImpl.class);

	static {
		studentList = new ArrayList<Student>();
	}

	@Override
	public boolean add(Student student) {
		logger.info("add method called");
		studentList.add(student);
		return true;
	}

	@Override
	public boolean addStudentToFile(Student student) throws IOException {
		logger.info("addStudentToFile method called");
		try (FileWriter fileWriter = new FileWriter(
				FileManagerDao.getFileName("txt"), true);
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
			bufferWriter.write(student.toTxtFile());
			bufferWriter.write(System.lineSeparator());
		} catch (IOException e) {
			logger.error(e.getMessage() + student.toString());
			throw e;
		}

		return true;
	}

	@Override
	public boolean addToJsonFile(Student student) throws IOException {
		// TODO Auto-generated method stub

		return true;
	}

}
