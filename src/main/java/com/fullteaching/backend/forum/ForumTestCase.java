package com.fullteaching.backend.forum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ForumTestCase {

	private Forum forumA;
	private Forum forumB;
	
	@BeforeEach
	void setUp()
	{
		forumA = new Forum();
		forumB = new Forum(false);
	}
	
	@Test
	void testActivatedStatus() 
	{
		assertTrue(forumA.isActivated());
		assertFalse(forumB.isActivated());
	}
	
	@Test
	void testHasEntries()
	{
		assertNotNull(forumA.getEntries());
		assertTrue(forumA.getEntries().size() > 0);
		assertNotNull(forumB.getEntries());
		assertTrue(forumB.getEntries().size() > 0);
	}

}
