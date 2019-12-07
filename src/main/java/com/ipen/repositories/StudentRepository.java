package com.ipen.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ipen.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("select s from Student s where s.id=?1")
	Student findByStudentId(int id);

	@Query("select s from Student s where s.id=?1")
	Student findByStudentId(String id);

}
