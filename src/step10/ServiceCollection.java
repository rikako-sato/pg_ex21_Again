package step10;

public class ServiceCollection implements Service {

	public Object code;

	DayService dayService = new DayService();
	FamilyService familyService = new FamilyService();
	Nightservice nightService = new Nightservice();
	MorningService morningService = new MorningService();

	public Object code(){

		return code;
	}

	public void checkService(Record record){
		dayService.checkService(record);
		familyService.checkService(record);
		nightService.checkService(record);
		morningService.checkService(record);
	}


	public int calcBasicCharge(int basicCharge) {

			//DayServiseクラスの計算メソッドを呼び出す
		     basicCharge = dayService.calcBasicCharge(basicCharge);
			//familyServiceクラスの計算メソッドを呼びだす
			basicCharge =familyService.calcBasicCharge(basicCharge);
			//nightServiceクラスの計算メソッドを呼び出す
			basicCharge =nightService.calcBasicCharge(basicCharge);
			//morningServiceクラスの計算メソッドを呼び出す
			basicCharge =morningService.calcBasicCharge(basicCharge);

			return basicCharge;

		}

	public int calcUnitPrice(Record record, int unitPrice) {


			//DayServiseクラスの計算メソッドを呼び出す
			unitPrice = dayService.calcUnitPrice(record, unitPrice);

			//familyServiceクラスの計算メソッドを呼びだす
			unitPrice = familyService.calcUnitPrice(record, unitPrice);

			//nightServiceクラスの計算メソッドを呼びだす
			unitPrice = nightService.calcUnitPrice(record, unitPrice);

			//morningServiceクラスの計算メソッドを呼びだす
			unitPrice = morningService.calcUnitPrice(record, unitPrice);
			return unitPrice;

	}



	public void clear() {
		dayService.clear();
		familyService.clear();
		nightService.clear();
		morningService.clear();

	}

}


