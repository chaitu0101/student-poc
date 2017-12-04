
package com.student.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.student.application.models.Student;
import com.student.application.repository.StudentRepository;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	/*@RequestMapping("/addStudent")
	public String addStudent() {
		
		return "addStudent";
    	
    }*/

	
	@RequestMapping("/students")
	public String index(Model model) {
		List<Student> students = (List<Student>) studentRepository.findAll();
		model.addAttribute("students", students);
    	return "students";
    }
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"}, produces = {"application/json"})
	public Student create(@RequestBody Student student) {
	 student = studentRepository.save(student);
	    return student;
	}
	
	@RequestMapping(value="/editStudent",method=RequestMethod.GET)
	public Student edit(@RequestParam(value="studentId") int studentId)
	{
		Student student = studentRepository.findByStudentId(studentId);
		return student;
		
	}
	
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public List<Student> update(@RequestBody Student student) {
		Student currentprofile = new Student();
		currentprofile.setName(student.getName());
		currentprofile.setEmailId(student.getEmailId());
		currentprofile.setPhone(student.getPhone());
		currentprofile.setDob(student.getDob());
		currentprofile.setAddress(student.getAddress());
		currentprofile.setStudentId(student.getStudentId());
		student = studentRepository.save(currentprofile);
		return (List<Student>)studentRepository.findAll();
	}
	
	
	
	
	
	@RequestMapping(value="/allStudents",method=RequestMethod.GET)
	 public @ResponseBody List<Student> getStudents() {
        return (List<Student>)studentRepository.findAll();
    } 
	
	
	
	

	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void delete(@RequestParam(value="studentId") int studentId) {
		
		studentRepository.deleteByStudentId(studentId);
		

	}
}
