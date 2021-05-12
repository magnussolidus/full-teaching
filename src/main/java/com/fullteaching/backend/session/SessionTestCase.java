package com.fullteaching.backend.session;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.sun.jna.platform.win32.Netapi32Util.User;

class SessionTestCase {
	
	private com.fullteaching.backend.user.User teacher;
	private Course courseA;
	private Session sessionA;
	private Session sessionB;

	@BeforeEach
	void setUp() 
	{
		teacher = new com.fullteaching.backend.user.User("Vânia Neves", "pass", null, "Teacher");
		courseA = new Course("Programação", "prog01.png", teacher);
		sessionA = new Session("Aula 01", "Primeira aula", Long.MIN_VALUE);
		sessionB = new Session("Aula 02", "Segunda aula", Long.MAX_VALUE, courseA);
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

}
