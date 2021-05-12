package com.fullteaching.backend.course;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

class CourseTestCase {
	
	private User teacher;
	private Course courseA;
	private Course courseB;
	private CourseDetails courseB_details;
	private Course simpleCourse;

	@BeforeEach
	void setUp() 
	{
		teacher = new User("Vânia Neves", "pass", null, "Teacher");
		courseA = new Course("Programação", "prog01.png", teacher);
		courseB_details = new CourseDetails(courseB);
		courseB = new Course("Qualidade e Teste", "q&t.png", teacher, courseB_details);
		simpleCourse = new Course();
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

	@Test
	void testSetId()
	{
		simpleCourse.setId(Long.MIN_VALUE);
		assertEquals(simpleCourse.getId(), Long.MIN_VALUE);
	}
	
	@Test
	void testSetTile()
	{
		simpleCourse.setTitle("exemplo");
		assertEquals(simpleCourse.getTitle(), "exemplo");
	}
	
	@Test
	void testSetImage()
	{
		simpleCourse.setImage("curso_uff.png");
		assertEquals(simpleCourse.getImage(), "curso_uff.png");
	}
	
	@Test
	void testSetTeacher()
	{
		simpleCourse.setTeacher(teacher);
		assertEquals(simpleCourse.getTeacher(), teacher);
	}
	
	@Test
	void testSetCourseDetails()
	{
		simpleCourse.setCourseDetails(courseB_details);
		assertEquals(simpleCourse.getCourseDetails(), courseB_details);
	}
	
	@Test
	void testToString()
	{
		assertNotNull(courseA.toString());
	}
	
	@Test
	void testEqualsToNull()
	{
		assertFalse(courseB.equals(null));
	}
	
	@Test
	void testEqualsToSelf()
	{
		assertTrue(courseB.equals(courseB));
	}
	
	@Test
	void testEqualsToDifferentType()
	{
		assertFalse(courseB.equals(courseB_details));
	}
	
	@Test
	void testEqualsBySameId()
	{
		simpleCourse.setId(Long.MIN_VALUE);
		courseA.setId(Long.MIN_VALUE);
		assertTrue(courseA.equals(simpleCourse));
	}
	
	@Test
	void testEqualsByDifferentId()
	{
		simpleCourse.setId(Long.MAX_VALUE);
		courseB.setId(Long.MIN_VALUE);
		assertFalse(courseB.equals(simpleCourse));
	}
	
	@Test
	void testGetAttenders()
	{
		assertNotNull(courseA.getAttenders());
	}
	
	@Test
	void testSetAttenders()
	{
		Set<User> aux = new HashSet<>();
		simpleCourse.setAttenders(aux);
		assertEquals(simpleCourse.getAttenders(), aux);
	}
	
	@Test
	void testGetSessions()
	{
		assertNotNull(courseA.getSessions());
	}
	
	@Test
	void testSetSessions()
	{
		Set<Session> aux = new HashSet<>();
		simpleCourse.setSessions(aux);
		assertEquals(simpleCourse.getSessions(), aux);
	}
}
