package TesteUnitario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fullteaching.backend.file.File;

class FileTestCase {
	
	private File sampleFile;
	private File failFile;

	@BeforeEach
	void setUp()
	{
		sampleFile = new File(1, "slide01.pdf");
		failFile = new File(14, "index.html");
	}
	
	@Test
	void testFileType() {
		assertTrue(sampleFile.getType() >= 0 && sampleFile.getType() <= 2);
		assertFalse(failFile.getType() > 3 && failFile.getType() < 0);
	}
	
	@Test
	void testFileIntegrity(File sample)
	{
		assertTrue(sample.getType() >= 0 && sample.getType() <= 3);
		assertNotNull(sample.getLink());
		assertNotNull(sample.getName());
		assertFalse(sample.getName().length() <= 4);
		assertNotNull(sample.getNameIdent());
		assertFalse(sample.getNameIdent().length() == 0);
	}

}
