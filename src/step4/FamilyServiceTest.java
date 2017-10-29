package step4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyServiceTest {

	@Test
	public void testCheckService() {
		DayService dayService = new DayService();

		// インスタンスを作成した直後は、加入フラグはfalse
		assertFalse(dayService.checkService(null));

		// 家族割引意外のレコードの場合、加入フラグはfalseのまま
		assertFalse(dayService.checkService(new Record("2 E1")));

		// 家族割引のレコードの場合、加入フラグがtrueになる
		assertTrue(dayService.checkService(new Record("2 C1 090-1234-0001")));

		// clear()メソッドを呼び出すと、加入フラグがfalseになる
		dayService.clear();
		assertFalse(dayService.checkService(null));
	}


	@Test
	public void testcalcBasicCharge() {
		FamilyService familyService = new FamilyService();
		familyService.clear();
		assertEquals(1000,familyService.calcBasicCharge(1000));

		familyService.checkService(new Record("2 C1"));
		assertEquals(1100,familyService.calcBasicCharge(1000));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testfamilyNum(){
		FamilyService familyService = new FamilyService();

		familyService.clear();
		assertNull(null,familyService.familyNum(new Record("090-1234-0002")));

		String[] FamilyNum = familyService.familyNum(new Record("2 C1 090-1234-0002"));
		assertEquals("090-1234-0002",FamilyNum);

	}

}
