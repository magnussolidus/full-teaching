package com.fullteaching.backend.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileTestCase {
	
	private File sampleFile;
	private File failFile;
	private File simpleFile;
	private File linkedFile;
	private File indexedFile;

	@BeforeEach
	void setUp()
	{
		simpleFile = new File();
		sampleFile = new File(1, "slide01.pdf");
		linkedFile = new File(0, "selenium.pdf", "https://drive.google.com/file/d/153UPb3RbkqIUvVpkSu8j7DxcokBcNHTc/view");
		indexedFile = new File(2, "Tutorial JMeter iniciantes", "https://www.youtube.com/watch?v=8v1t3DOki4c", 4);
		failFile = new File(14, "index.html");
	}
	
	@Test
	void testSimpleFile()
	{
		assertNotNull(simpleFile);
	}
	
	@Test
	void testSetId()
	{
		linkedFile.setId(3);
		assertEquals(linkedFile.getId(), 3);
	}
	
	@Test
	void testSetType()
	{
		simpleFile.setType(1);
		assertEquals(simpleFile.getType(), 1);
	}
	
	
	@Test
	void testFileTypeIsWebLink()
	{
		assertEquals(linkedFile.getType(), 0);
	}
	
	@Test
	void testFileTypeIsPdf()
	{
		assertEquals(sampleFile.getType(), 1);
	}
	
	@Test
	void testFileTypeIsVideo()
	{
		assertEquals(indexedFile.getType(), 2);
	}
	
	@Test
	void testGetName()
	{
		assertEquals(sampleFile.getName(), "slide01.pdf");
	}
	
	@Test
	void testSetName()
	{
		simpleFile.setName("tested");
		assertEquals(simpleFile.getName(), "tested");
	}
	
	@Test
	void testGetFileExtension()
	{
		assertEquals(linkedFile.getFileExtension(), "pdf");
	}
	
	@Test
	void testGetFileLink()
	{
		assertEquals(indexedFile.getLink(), "https://www.youtube.com/watch?v=8v1t3DOki4c");
	}
	
	@Test
	void testSetFileLink()
	{
		simpleFile.setLink("https://www.google.com");
		assertEquals(simpleFile.getLink(), "https://www.google.com");
	}
	
	@Test
	void testGetIndexOrder()
	{
		assertEquals(indexedFile.getIndexOrder(), 4);
	}
	
	@Test
	void testSetIndexOrder()
	{
		simpleFile.setIndexOrder(1);
		assertEquals(simpleFile.getIndexOrder(), 1);
	}
	
	@Test
	void testFileEqualsNewFile()
	{
		File aux = new File();
		assertTrue(simpleFile.equals(aux));
	}
	
	@Test
	void testFileEqualsNullOther()
	{
		assertFalse(simpleFile.equals(null));
	}
	
	@Test
	void testFileEqualsItself()
	{
		assertTrue(simpleFile.equals(simpleFile));
	}
	
	@Test
	void testFileNotEqualsItself()
	{
		assertTrue(sampleFile.equals(failFile));
	}
}
