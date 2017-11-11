package step8;

public class ServiceCollection implements Service {

	private String Normal;
	private String E1;
	private String C1;
	public Object code;

	DayService dayService = new DayService();
	FamilyService familyService = new FamilyService();

	public Object code(){

		return code;
	}


	public void checkService(Record record) {
		if (record.getServiceCode().equals("E1")) {
			code = E1;
		}else if(record.getServiceCode().equals("C1")){
			code = C1;
		}


	}

	public int calcBasicCharge(int basicCharge) {

		if(code == E1){
			//DayServiseクラスの計算メソッドを呼び出す
			basicCharge = dayService.calcBasicCharge(basicCharge);
			return basicCharge;


		}else if(code == C1){
			//familyServiceクラスの計算メソッドを呼びだす
			basicCharge =familyService.calcBasicCharge(basicCharge);
			return basicCharge;
		}

		return basicCharge;
		}

	public int calcUnitPrice(Record record, int unitPrice) {

		if(code == E1){
			//DayServiseクラスの計算メソッドを呼び出す
			unitPrice = dayService.calcUnitPrice(record, unitPrice);
			return unitPrice;

		}else if(code == C1){
			//familyServiceクラスの計算メソッドを呼びだす
			unitPrice = familyService.calcUnitPrice(record, unitPrice);
			return unitPrice;
		}

		return unitPrice;
	}



	public void clear() {

	}

}


