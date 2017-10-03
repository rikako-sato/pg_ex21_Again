package step1;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayServiceTest {

	@Test
	public void test1() {
		DayService dayService = new DayService();
		assertEquals(1200,dayService.getBasicCharge());
	}

	@Test
	public void test2() {
		DayService dayService = new DayService();
		assertEquals(15,dayService.getDiscount());
	}


}
