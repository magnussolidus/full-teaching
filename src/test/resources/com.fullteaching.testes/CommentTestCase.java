package com.fullteaching.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fullteaching.backend.comment.Comment;
import com.sun.jna.platform.win32.Netapi32Util.User;

class CommentTestCase {

	private Comment commentA;
	private Comment answerA;
	private User studentA;
	private User studentB;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", null, "Student");
		studentB = new User("Bacharelando SI", "pass", null, "Student");
		commentA = new Comment("Que horas são?", Long.MIN_VALUE, studentA);
		answerA = new Comment("Hora de aventura!", Long.MAX_VALUE, studentB, commentA);)
	}
	
	@Test
	void testValidMessage(Comment sample) 
	{
		assertNotNull(sample.getMessage());
		assertTrue(sample.getMessage().length() > 0);
	}
	
	@Test
	void testValidAnswer(Comment answer)
	{
		assertNotNull(answer.getMessage());
		assertNotNull(answer.getCommentParent());
		assertTrue(answer.getMessage().length() > 0);
		assertTrue(answer.getDate() > answer.getCommentParent().getDate());
		assertTrue(answer.getCommentParent().getReplies().size() > 0);
	}

}
