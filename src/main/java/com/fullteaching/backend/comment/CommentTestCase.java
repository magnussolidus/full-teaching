package com.fullteaching.backend.comment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;

class CommentTestCase {

	private Comment commentA;
	private Comment answerA;
	private Comment simpleComment;
	private User studentA;
	private User studentB;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", "magnussolidus", null, "Student");
		studentB = new User("Bacharelando SI", "pass", "calouro", null, "Student");
		commentA = new Comment("Que horas são?", Long.MIN_VALUE, studentA);
		answerA = new Comment("Hora de aventura!", Long.MAX_VALUE, studentB, commentA);
		simpleComment = new Comment();
	}
	
	@Test
	void testValidMessage() 
	{
		assertNotNull(commentA.getMessage());
	}
	
	
	@Test
	void testSetId()
	{
		simpleComment.setId(Long.MAX_VALUE);
		assertEquals(simpleComment.getId(), Long.MAX_VALUE);
	}
	
	@Test
	void testSetMessage()
	{
		simpleComment.setMessage("Exemplo");
		assertEquals(simpleComment.getMessage(), "Exemplo");
	}
	
	@Test
	void testSetDate()
	{
		simpleComment.setDate(Long.MIN_VALUE);
		assertEquals(simpleComment.getDate(), Long.MIN_VALUE);
	}
	
	@Test
	void testToString()
	{
		Comment a[] = new Comment[] {answerA};
		List<Comment> roles = Arrays.asList(a);
		commentA.setReplies(roles);
		System.out.print(commentA.getReplies().size());
		assertNotNull(commentA.toString());
		
		commentA.setReplies(null);
		assertNotNull(commentA.toString());
		
		assertNotNull(answerA.toString());
		
		answerA.setUser(null);
		assertNotNull(answerA.toString());
	}
	
	
	@Test
	void testSetCommentParent()
	{
		answerA.setCommentParent(commentA);
		assertEquals(answerA.getCommentParent(), commentA);
	}
	
	@Test
	void testSetUser()
	{
		commentA.setUser(studentB);
		assertEquals(commentA.getUser(), studentB);
	}

}
