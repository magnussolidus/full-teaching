package TesteUnitario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rometools.rome.feed.atom.Entry;
import com.sun.jna.platform.win32.Netapi32Util.User;

class EntryTestCase {

	private User studentA;
	private Entry sampleEntry;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", null, "Student");
		sampleEntry = new Entry("Olá Mundo!", Long.MIN_VALUE, studentA);
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
	void testEntryIntegrity(Entry sample)
	{
		assertNotNull(sample.getTitle());
		assertTrue(sample.getTitle().length() > 0);
		assertNotNull(sample.getDate());
		assertNotNull(sample.getUser());
	}
	
	@Test
	void testHasComments(Entry sample)
	{
		assertNotNull(sample.getComments());
		assertTrue(sample.getComments().size > 0);
	}

}
