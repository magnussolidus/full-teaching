package com.fullteaching.backend.user;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;

class UserTestCase {
	
	private User studentA;
	private User studentB;
	private User teacher;
	private User simpleUser;
	private Course sampleCourse;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", "magnussolidus", null, "Student");
		studentB = new User("Bacharelando SI", "pass", "calouro", "", "Student", "User");
		teacher = new User("Vânia Neves", "pass", "Drª", "teacher_avatar.png", "Teacher");
		simpleUser = new User();
		sampleCourse = new Course("Qualidade e Teste", "q&a.png", teacher);
	}

	@Test
	void testGetName() {
		assertEquals(studentA.getName(), "Magno Lomardo");
		assertEquals(studentB.getName(), "Bacharelando SI");
		assertEquals(teacher.getName(), "Vânia Neves");
	}
	
	@Test
	void testGetPicture()
	{
		assertEquals(studentA.getPicture(), "/../assets/images/default_session_image.png");
		assertEquals(studentB.getPicture(), "/../assets/images/default_session_image.png");
		assertEquals(teacher.getPicture(), "teacher_avatar.png");
	}
	
	@Test
	void testeGetStudentRole()
	{
		String r[] = new String[] {"Student"};
		List<String> roles = Arrays.asList(r);
		assertEquals(studentA.getRoles(), roles);
	}
	
	@Test
	void testGetId()
	{
		simpleUser.setId(Long.MIN_VALUE);
		assertEquals(simpleUser.getId(), Long.MIN_VALUE);
	}
	
	@Test
	void testSetName()
	{
		simpleUser.setName("exemplo");
		assertEquals(simpleUser.getName(), "exemplo");
	}
	
	@Test
	void testSetNickname()
	{
		assertEquals(studentA.getNickName(), "magnussolidus");
	}
	
	@Test
	void testToString()
	{
		studentA.setNickName("toString");
		assertEquals(studentA.getNickName(), studentA.toString());
	}
	
	@Test
	void testHashcode()
	{
		assertEquals(studentA.hashCode(), studentA.getName().hashCode());
	}
	
	@Test
	void testSetPasswordHash()
	{
		simpleUser.setPasswordHash("abc123");
		assertEquals(simpleUser.getPasswordHash(), "abc123");
	}
	
	@Test
	void testSetRoles()
	{
		String r[] = new String[] {"User", "Student"}; 
		List<String> roles = Arrays.asList(r);
		simpleUser.setRoles(roles);
		assertEquals(simpleUser.getRoles(), roles);
	}
	
	@Test
	void testSetPicture()
	{
		studentB.setPicture("calouro.jpeg");
		assertEquals(studentB.getPicture(), "calouro.jpeg");
	}
	
	@Test
	void testGetRegistrationDate()
	{
		assertNotNull(studentB.getRegistrationDate());
	}
	
	@Test
	void testSetRegistrationDate()
	{
		studentA.setRegistrationDate(Long.MIN_VALUE);
		assertEquals(studentA.getRegistrationDate(), Long.MIN_VALUE);
	}
	
	@Test
	void testGetCourses()
	{
		Set<Course> aux = new HashSet<>();
		teacher.setCourses(aux);
		assertEquals(teacher.getCourses(), aux);
	}
	
	@Test
	void testUserEqualsNull()
	{
		assertFalse(studentA.equals(null));
	}
	
	@Test
	void testUserEqualsItself()
	{
		assertTrue(studentA.equals(studentA));
	}
	
	@Test
	void testUserEqualsDifferentObject()
	{
		assertFalse(studentA.equals(sampleCourse));
	}
	
	@Test
	void testUserEqualsUserCopy()
	{
		studentA.setId(Long.MAX_VALUE);
		simpleUser.setId(Long.MAX_VALUE);
		simpleUser.setName(studentA.getName());
		assertTrue(studentA.equals(simpleUser));
	}
	
	@Test
	void testUserDiffersNameFromUserCopy()
	{
		studentA.setId(Long.MAX_VALUE);
		simpleUser.setId(Long.MAX_VALUE);
		simpleUser.setName("Manoel");
		assertFalse(studentA.equals(simpleUser));
	}

}
