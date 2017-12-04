package com.student.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.application.models.Courses;
import com.student.application.models.Student;
import com.student.application.repository.CourseRepository;
import com.student.application.repository.StudentRepository;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	
	

		@RequestMapping(value="/getCourses",method=RequestMethod.GET)
		 public @ResponseBody List<Courses> getCourses() {
	        return (List<Courses>)courseRepository.findAll();
	    } 
		
		@RequestMapping(value="/getCourse",method=RequestMethod.GET)
		public Courses getCourse(@RequestParam(value="courseId") int courseId){
	        Courses course= courseRepository.findByCourseId(courseId);
			return course;
	    }
		
	
	
}
