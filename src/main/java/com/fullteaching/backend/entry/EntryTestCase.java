package com.fullteaching.backend.entry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rometools.rome.feed.atom.Entry;
import com.fullteaching.backend.user.User;

class EntryTestCase {

	private com.fullteaching.backend.user.User studentA;
	private com.fullteaching.backend.entry.Entry sampleEntry;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", null, "Student");
		sampleEntry = new com.fullteaching.backend.entry.Entry("Olá Mundo!", Long.MIN_VALUE, studentA);
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
		assertTrue(sampleEntry.getTitle().length() > 0);
		assertNotNull(sampleEntry.getDate());
		assertNotNull(sampleEntry.getUser());
	}
	
	@Test
	void testHasComments()
	{
		assertNotNull(sampleEntry.getComments());
		assertTrue(sampleEntry.getComments().size() > 0);
	}

}
