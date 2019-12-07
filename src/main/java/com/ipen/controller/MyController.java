package com.ipen.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipen.entities.Student;
import com.ipen.model.StudentDTO;
import com.ipen.repositories.StudentRepository;
import com.ipen.services.StudentService;

@RestController
public class MyController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired StudentRepository studentRepository;
	
	@RequestMapping("/")
	public String home() {
	return "Welcome";
	}
	
	@RequestMapping(method =RequestMethod.POST, value="/addStudents")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudents(student);
		
	}
	
	@RequestMapping("/getStudents")
	public List<StudentDTO> listStudents(){
		
		List <Student> student = new ArrayList<Student>();
		student =(List<Student>) studentRepository.findAll();
		
		List<StudentDTO> dtolist = new ArrayList<StudentDTO>();
		for(Student s: student)
		{
			StudentDTO dto = new StudentDTO();
			dto.setId(s.getId());
			dto.setAddress(s.getAddress());
			dto.setName(s.getName());
			dto.setNumber(s.getNumber());
			dtolist.add(dto);
		}
		
		
		return dtolist;
		
	}
	@RequestMapping(method = RequestMethod.POST, value="/deleteStudent")
	public void deleteStudent(HttpServletRequest request ){
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentRepository.findByStudentId(id);
		studentRepository.delete(student);
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/updateStudent")
	public StudentDTO updateStudent(@RequestParam int id) {
		StudentDTO studentDTO =studentService.updateStudents(id);
		return studentDTO;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/updateStudent")
	public void updatedStudent(@RequestParam int id, StudentDTO studentDTO) {
		studentService.updateStudents(id, studentDTO );
		
	}

}
