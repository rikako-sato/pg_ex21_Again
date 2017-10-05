package step2;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyServiceTest {

	@Test
	public void testcalcBasicCharge() {
		FamilyService familyService = new FamilyService();
		familyService.clear();
		assertEquals(1000,familyService.calcBasicCharge(1000));

		familyService.checkService("2 C1");
		assertEquals(1100,familyService.calcBasicCharge(1000));
	}
	@Test
	public void testfamilyNum(){
		FamilyService familyService = new FamilyService();

		familyService.clear();
		assertEquals(null,familyService.familyNum("090-1234-0002"));

		String FamilyNum = familyService.familyNum("2 C1 090-1234-0002");
		assertEquals("090-1234-0002",FamilyNum);

	}

}
