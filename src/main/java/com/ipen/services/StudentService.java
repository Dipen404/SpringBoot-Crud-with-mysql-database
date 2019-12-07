package com.ipen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipen.entities.Student;
import com.ipen.model.StudentDTO;
import com.ipen.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public void addStudents(Student student) {
		studentRepository.save(student);
		
	}

	public StudentDTO updateStudents(int id) {
		Student student = studentRepository.findByStudentId(id);
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setAddress(student.getAddress());
		studentDTO.setName(student.getName());
		studentDTO.setNumber(student.getNumber());
		return studentDTO;
		
	}

	public void updateStudents(int id, StudentDTO studentDTO) {
		Student student = studentRepository.findByStudentId(id);
		student.setAddress(studentDTO.getAddress());
		student.setName(studentDTO.getName());
		student.setNumber(studentDTO.getNumber());
		
	}
	

}
