package com.fullteaching.backend.forum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.entry.Entry;

class ForumTestCase {

	private Forum forumA;
	private Forum forumB;
	private Entry simpleEntry;
	private Comment simpleComment;
	
	@BeforeEach
	void setUp()
	{
		forumA = new Forum();
		forumB = new Forum(false);
		simpleEntry = new Entry();
		simpleComment = new Comment();
		Comment c[] = new Comment[] {simpleComment};
		List<Comment> comments = Arrays.asList(c);
		simpleEntry.setComments(comments);
	}
	
	@Test
	void testGetActivated() 
	{
		assertFalse(forumB.isActivated());
	}
	
	@Test
	void testSetActivated()
	{
		forumB.setActivated(true);
		assertTrue(forumB.isActivated());
	}
	
	@Test
	void testSetId()
	{
		forumA.setId(Long.MAX_VALUE);
		assertEquals(forumA.getId(), Long.MAX_VALUE);
	}
	
	@Test
	void testGetEntries()
	{
		assertNotNull(forumB.getEntries());
	}
	
	@Test
	void testSetEntries()
	{
		Entry e[] = new Entry[] {simpleEntry};
		List<Entry> entries = Arrays.asList(e);
		forumB.setEntries(entries);
		assertEquals(forumB.getEntries(), entries);
	}
	
	@Test
	void testToString()
	{
		assertNotNull(forumB.toString());
		
		Entry e[] = new Entry[] {simpleEntry};
		List<Entry> entries = Arrays.asList(e);
		forumA.setEntries(entries);
		assertNotNull(forumA.toString());
	}

}
