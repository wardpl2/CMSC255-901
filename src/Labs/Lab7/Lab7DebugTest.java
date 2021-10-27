package Labs.Lab7;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab7DebugTest {

	@Test
	public void GCDTest1() {
		assertEquals("When checking the GCD of 10 and 2 we",2,Lab7Debug.GCD(2, 10));
	}

	@Test
	public void GCDTest2() {
		assertEquals("When checking the GCD of 128 and 32 we",32,Lab7Debug.GCD(128, 32));
	}

	@Test
	public void GCDTest3() {
		assertEquals("When checking the GCD of 635 and 200 we",5,Lab7Debug.GCD(635, 200));
	}

	public void GCDTest4() {
		assertEquals("When checking the GCD of 654321 and 123456 we",3,Lab7Debug.GCD(654321, 123456));
	}

	@Test
	public void GCDTest5() {
		assertEquals("When checking the GCD of 75614 and 28105 we",77,Lab7Debug.GCD(75614, 28105));
	}
	
}
