package com.jyoti.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyoti.entity.Student;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
	private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "Jyoti"), new Student(2, "Prakash"),
			new Student(3, "Behera"), new Student(4, "Chinku"));

	@GetMapping(path = "/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return STUDENTS.parallelStream().filter(student -> studentId == student.getId()).findFirst().orElseThrow(
				() -> new IllegalStateException("Student with Student ID" + studentId + " Does not exist.."));
	}

}
