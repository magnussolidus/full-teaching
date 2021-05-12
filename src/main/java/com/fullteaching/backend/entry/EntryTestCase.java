package com.fullteaching.backend.entry;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.entry.Entry;
import com.fullteaching.backend.user.User;

class EntryTestCase {

	private User studentA;
	private Entry sampleEntry;
	private Entry simpleEntry;
	private Comment commentA;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", null, "Student");
		sampleEntry = new Entry("Olá Mundo!", Long.MIN_VALUE, studentA);
		simpleEntry = new Entry();
		commentA = new Comment("Que horas são?", Long.MIN_VALUE, studentA);
	}
	
	@Test
	void testGetUser() 
	{
		assertEquals(sampleEntry.getUser(), studentA);
	}
	
	@Test
	void testGetTitle()
	{
		assertEquals(sampleEntry.getTitle(), "Olá Mundo!");
	}
	
	@Test
	void testGetDate()
	{
		assertEquals(sampleEntry.getDate(), Long.MIN_VALUE);
	}
	
	@Test
	void testEntryIntegrity()
	{
		assertNotNull(sampleEntry.getTitle());
		assertNotNull(sampleEntry.getDate());
		assertNotNull(sampleEntry.getUser());
	}
	
	@Test
	void testGetComments()
	{
		assertNotNull(sampleEntry.getComments());
	}
	
	@Test
	void testSetId()
	{
		simpleEntry.setId(Long.MAX_VALUE);
		assertEquals(simpleEntry.getId(), Long.MAX_VALUE);
	}
	
	@Test
	void testSetTitle()
	{
		simpleEntry.setTitle("Exemplo");
		assertEquals(simpleEntry.getTitle(), "Exemplo");
	}
	
	@Test
	void testSetDate()
	{
		simpleEntry.setDate(Long.MAX_VALUE);
		assertEquals(simpleEntry.getDate(), Long.MAX_VALUE);
	}
	
	@Test
	void testSetUser()
	{
		simpleEntry.setUser(studentA);
		assertEquals(simpleEntry.getUser(), studentA);
	}
	
	@Test
	void testSetComments()
	{
		Comment a[] = new Comment[] {commentA};
		List<Comment> comments = Arrays.asList(a);
		simpleEntry.setComments(comments);
		assertEquals(simpleEntry.getComments(), comments);
	}
	
	@Test
	void testToString()
	{
		assertNotNull(sampleEntry.toString());
	}

}
