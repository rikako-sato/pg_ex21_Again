package step9;

import static org.junit.Assert.*;

import org.junit.Test;

public class NightserviceTest {

	@Test
	public void testCheckService() {
		Nightservice nightService = new Nightservice();
		// インスタンスを作成した直後は、加入フラグはfalse
		assertFalse(nightService.isJoined());

		// 夜トク割引意外のレコードの場合、加入フラグはfalseのまま
		nightService.checkService(new Record("2 C1 090-1234-0001"));
		assertFalse(nightService.isJoined());

		// 夜トク割引のレコードの場合、加入フラグがtrueになる
		nightService.checkService(new Record("2 E3"));
		assertTrue(nightService.isJoined());

		// clear()メソッドを呼び出すと、加入フラグがfalseになる
		nightService.clear();
		assertFalse(nightService.isJoined());



	}

	@Test
	public void testIsServiceTime() {
		Nightservice nightService = new Nightservice();

		// 夜トク割引に加入していない場合は、どの時間も昼トク割引の対象にならない
		assertFalse(nightService.isServiceTime(22));
		assertFalse(nightService.isServiceTime(23));
		assertFalse(nightService.isServiceTime(3));
		assertFalse(nightService.isServiceTime(4));

		// 夜トク割引に介入している場合は、23:00時から3:59分までに開始された通話は割引対象になる
		nightService.checkService(new Record("2 E3"));
		assertFalse(nightService.isServiceTime(22));
		assertTrue(nightService.isServiceTime(23));
		assertTrue(nightService.isServiceTime(3));
		assertFalse(nightService.isServiceTime(4));

	}

	@Test
	public void testCalcUnitPrice() {
		Nightservice nightService = new Nightservice();

		nightService.checkService(new Record("2 E3"));

		// 夜トク割引の対象外の時間の場合、単価は変わらない
		int unitPrice = nightService.calcUnitPrice(new Record("5 2004/06/05 22:59 010 090-1234-0002"), 20);
		assertEquals(20, unitPrice);

		// 夜トク割引の対象の時間の場合、単価は15円引き
		unitPrice = nightService.calcUnitPrice(new Record("5 2004/06/05 23:00 010 090-1234-0002"), 20);
		assertEquals(5, unitPrice);
	}

	@Test
	public void testCalcBasicCharge() {
		Nightservice nightService = new Nightservice();

		// 夜トク割引に加入していない場合、基本料金は変わらない
		int basicCharge = nightService.calcBasicCharge(1000);
		assertEquals(1000, basicCharge);

		// 夜トク割引に加入している場合、基本料金は500円増し
		nightService.checkService(new Record("2 E3"));
		basicCharge = nightService.calcBasicCharge(1000);
		assertEquals(1500, basicCharge);
	}

}
