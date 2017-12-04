package com.student.application.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

import com.student.application.models.Courses;

@Transactional
public interface CourseRepository extends CrudRepository<Courses,Integer> {

	 public Courses findByCourseId(int courseId);
 
	 public List<Courses> findAll();

}
