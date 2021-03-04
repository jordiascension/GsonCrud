package com.netmind.dao.contracts;

import java.io.IOException;

import com.netmind.model.Student;

public interface StudentDao {
	boolean add(Student student) throws IOException;

	boolean addToJsonFile(Student student) throws IOException;

	boolean addStudentToFile(Student student) throws IOException;
}
