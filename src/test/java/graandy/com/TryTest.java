package graandy.com;

import static org.junit.Assert.*;

import org.junit.Test;

public class TryTest {

	@Test
	public void testAdd() {
		Try t1 = new Try(10);
		Try t2 = new Try(20);
		Try exp = new Try(30);
		Try res = t1.Add(t2);
		if (!(res.value==exp.value))
		fail("Not yet implemented");
	}

}
