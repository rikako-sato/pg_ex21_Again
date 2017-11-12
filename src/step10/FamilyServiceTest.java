package step10;

import static org.junit.Assert.*;

import org.junit.Test;

public class FamilyServiceTest {

	@Test
	public void testCheckService() {
//		DayService dayService = new DayService();
//
//		// インスタンスを作成した直後は、加入フラグはfalse
//		assertFalse(dayService.checkService(null));
		FamilyService familyService = new FamilyService();

//		// 家族割引意外のレコードの場合、加入フラグはfalseのまま
//		assertFalse(dayService.checkService(new Record("2 E1")));
		// インスタンスを生成した直後は、加入フラグはfalse
		assertFalse(familyService.isJoined());

//		// 家族割引のレコードの場合、加入フラグがtrueになる
//		assertTrue(dayService.checkService(new Record("2 C1 090-1234-0001")));
		// 無関係なサービスレコードの場合、加入フラグはfalseのまま
		familyService.checkService(new Record("2 E1"));
		assertFalse(familyService.isJoined());

//		// clear()メソッドを呼び出すと、加入フラグがfalseになる
//		dayService.clear();
//		assertFalse(dayService.checkService(null));
		// 家族割引のサービスレコードの場合、加入フラグがtrueになる
		familyService.checkService(new Record("2 C1 090-1234-0001"));
		assertTrue(familyService.isJoined());
	}


	@Test
//	public void testcalcBasicCharge() {
	public void testIsFamilyNumber() {
		FamilyService familyService = new FamilyService();
//		familyService.clear();
//		assertEquals(1000,familyService.calcBasicCharge(1000));

//		familyService.checkService(new Record("2 C1"));
//		assertEquals(1100,familyService.calcBasicCharge(1000));
		// 加入フラグがfalseの場合、対象にはならない
		assertFalse(familyService.isFamilyTelNumber("090-1234-0001"));

		 // 通話先が割引対象の場合
		 familyService.checkService(new Record("2 C1 090-1234-0001"));
		 assertTrue(familyService.isFamilyTelNumber("090-1234-0001"));
		 // 通話先が割引対象外の場合
		 assertFalse(familyService.isFamilyTelNumber("090-1234-4321"));
	}
//	@SuppressWarnings("deprecation")
	@Test
//	public void testfamilyNum(){
	public void testCalcUnitPrice() {
		FamilyService familyService = new FamilyService();

//		familyService.clear();
//		assertNull(null,familyService.familyNum(new Record("090-1234-0002")));

//		String[] FamilyNum = familyService.familyNum(new Record("2 C1 090-1234-0002"));
//		assertEquals("090-1234-0002",FamilyNum);
		familyService.checkService(new Record("2 C1 090-1234-0001"));

		 // 家族割引対象外の通話先の場合、単価は変わらない
		 int unitPrice = familyService.calcUnitPrice(new Record("5 2004/06/05 17:50 010 090-1234-0002"), 15);
		 assertEquals(15, unitPrice);

		 // 家族割引対象外の通話先の場合、単価は半額(切り捨て)
		 unitPrice = familyService.calcUnitPrice(new Record("5 2004/06/05 17:50 010 090-1234-0001"), 15);
		 assertEquals(7, unitPrice);

	}
	@Test
	 public void testCalcBasicCharge() {
		FamilyService familyService = new FamilyService();
		// 家族割引に加入していない場合、基本料金は変わらない
		 int basicCharge = familyService.calcBasicCharge(1000);
		 assertEquals(1000, basicCharge);

		 // 家族割引に加入している場合、基本料金は100円増し
		 familyService.checkService(new Record("2 C1 090-1234-0001"));
		 basicCharge = familyService.calcBasicCharge(1000);
		 assertEquals(1100, basicCharge);
	}

}
