package TesteUnitario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.jna.platform.win32.Netapi32Util.User;

class UserTestCase {
	
	private User studentA;
	private User studentB;
	private User teacher;
	
	@BeforeEach
	void setUp()
	{
		studentA = new User("Magno Lomardo", "pass", null, "Student");
		studentB = new User("Bacharelando SI", "pass", null, "Student");
		teacher = new User("Vânia Neves", "pass", null, "Teacher");
	}

	@Test
	void testGetName() {
		assertEquals(studentA.getName(), "Magno Lomardo");
		assertEquals(studentB.getName(), "Bacharelando SI");
		assertEquals(teacher.getName(), "Vânia Neves");
	}
	
	@Test
	void testGetPasswordHash()
	{
		assertEquals(studentA.getPasswordHash, new BCryptPasswordEncoder().encode("pass"));
		assertEquals(studentB.getPasswordHash, new BCryptPasswordEncoder().encode("pass"));
		assertEquals(teacher.getPasswordHash, new BCryptPasswordEncoder().encode("pass"));
	}
	
	@Test
	void testGetPicture()
	{
		assertEquals(studentA.getPicture(), "/../assets/images/default_session_image.png");
		assertEquals(studentB.getPicture(), "/../assets/images/default_session_image.png");
		assertEquals(teacher.getPicture(), "/../assets/images/default_session_image.png");
	}
	
	@Test
	void testeGetRoles()
	{
		ArrayList<String> studentRoles = new ArrayList<String>();
		ArrayList<String> teacherRoles = new ArrayList<String>();
		studentRoles.add("Student");
		teacherRoles.add("Teacher");
		
		assertEquals(studentA.getRoles(), studentRoles);
		assertEquals(studentB.getRoles(), studentRoles);
		assertEquals(teacher.getRoles(), teacherRoles);
	}

}
