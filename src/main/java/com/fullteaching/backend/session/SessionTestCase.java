package com.fullteaching.backend.session;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;

class SessionTestCase {
	
	private com.fullteaching.backend.user.User teacher;
	private Course courseA;
	private Session sessionA;
	private Session sessionB;
	private Session simpleSession;

	@BeforeEach
	void setUp() 
	{
		teacher = new com.fullteaching.backend.user.User("Vânia Neves", "pass", null, "Teacher");
		courseA = new Course("Programação", "prog01.png", teacher);
		sessionA = new Session("Aula 01", "Primeira aula", Long.MIN_VALUE);
		sessionB = new Session("Aula 02", "Segunda aula", Long.MAX_VALUE, courseA);
		simpleSession = new Session();
	}

	@Test
	void testGetTitle() {
		assertEquals(sessionA.getTitle(), "Aula 01");
		assertEquals(sessionB.getTitle(), "Aula 02");
	}

	@Test
	void testGetDescription() {
		assertEquals(sessionA.getDescription(), "Primeira aula");
		assertEquals(sessionB.getDescription(), "Segunda aula");
	}

	@Test
	void testGetDate() {
		assertEquals(sessionA.getDate(), Long.MIN_VALUE);
		assertEquals(sessionB.getDate(), Long.MAX_VALUE);
	}

	@Test
	void testGetCourse() {
		assertEquals(sessionB.getCourse(), courseA);
	}
	
	@Test
	void testSimpleSession()
	{
		assertNotNull(simpleSession);
	}
	
	@Test
	void testGetId()
	{
		sessionA.setId(3);
		assertEquals(sessionA.getId(), 3);
	}
	
	@Test
	void testSetTitle()
	{
		simpleSession.setTitle("Alguma coisa");
		assertEquals(simpleSession.getTitle(), "Alguma coisa");
	}
	
	@Test
	void testSetDescription()
	{
		simpleSession.setDescription("descrição");
		assertEquals(simpleSession.getDescription(), "descrição");
	}
	
	@Test
	void testSetData()
	{
		simpleSession.setDate(Long.MIN_VALUE);
		assertEquals(simpleSession.getDate(), Long.MIN_VALUE);
	}
	
	@Test
	void testSetCourse()
	{
		simpleSession.setCourse(courseA);
		assertEquals(simpleSession.getCourse(), courseA);
	}
	
	@Test
	void testEqualsNull()
	{
		assertFalse(simpleSession.equals(null));
	}
	
	@Test
	void testEqualsSelf()
	{
		assertTrue(simpleSession.equals(simpleSession));
	}
	
	@Test
	void testEqualsOtherSession()
	{
		assertTrue(simpleSession.equals(sessionA));
	}
	
	@Test
	void testEqualsSessionsId()
	{
		simpleSession.setId(1);
		sessionA.setId(4);
		assertFalse(simpleSession.equals(sessionA));
	}
	
	@Test
	void testEqualsDifferentType()
	{
		assertFalse(simpleSession.equals(teacher));
	}
	
	@Test
	void testToStringLengthBiggerThenZero()
	{
		assertNotNull(sessionA.toString());
		assertTrue(sessionA.toString().length() > 0);
	}
	
	@Test
	void testToStringLengthLessThen512()
	{
		assertNotNull(sessionA.toString());
		assertTrue(sessionA.toString().length() < 512);
	}
	

}
