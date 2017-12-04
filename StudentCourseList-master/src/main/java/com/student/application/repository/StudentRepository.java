package com.student.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.student.application.models.Student;

@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByStudentId(int studentId);

	public int deleteByStudentId(int studentId);

}
