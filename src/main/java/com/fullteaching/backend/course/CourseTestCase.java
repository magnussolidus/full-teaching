package com.fullteaching.backend.course;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.user.User;

class CourseTestCase {
	
	private User teacher;
	private Course courseA;
	private Course courseB;
	private CourseDetails courseB_details;

	@BeforeEach
	void setUp() 
	{
		teacher = new User("Vânia Neves", "pass", null, "Teacher");
		courseA = new Course("Programação", "prog01.png", teacher);
		courseB = new Course("Qualidade e Teste", "q&t.png", teacher);
		courseB_details = new CourseDetails(courseB);
		courseB.setCourseDetails(courseB_details);
	}
	
	@Test
	void testGetTitle() {
		assertEquals(courseA.getTitle(), "Programação");
		assertEquals(courseB.getTitle(), "Qualidade e Teste");
	}
	
	@Test
	void testGetImage()
	{
		assertEquals(courseA.getImage(), "prog01.png");
		assertEquals(courseB.getImage(), "q&t.png");
	}
	
	@Test
	void testGetTeacher()
	{
		assertEquals(courseA.getTeacher(), teacher);
		assertEquals(courseB.getTeacher(), teacher);
	}
	
	@Test
	void testGetCourseDetails()
	{
		assertNotNull(courseB.getCourseDetails());
	}

}
