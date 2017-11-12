package step8;

public class FamilyService implements Service {

	private String[] telNumbers = new String[2];
	private int telNumberCount = 0;

//	 String [] familyNum = new String[2];

	private boolean joined = false;

	public boolean isJoined() {
		return joined;
	}

	// サービスに加入しているかをチェック
	public void checkService(Record record) {
	if (record.getServiceCode().equals("C1")) {
//		if (record.getServiceOption().equals("C1")) {
			joined = true;
			telNumbers[telNumberCount++] = record.getServiceOption();
		}
	}
	public boolean isFamilyTelNumber(String telNumber) {
		 	for (int i = 0; i < telNumberCount; i++){
		 			if (telNumbers[i].equals(telNumber)) {
		 				return true;
		 			}
		 	}
		 		return false;
	}
	public int calcBasicCharge(int basicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を100円増し
			return basicCharge + 100;
		}
		return basicCharge;
	}

	//家族の電話番号を取得
//	public String[] familyNum(Record record){
	// 単価を計算する
		 public int calcUnitPrice(Record record, int unitPrice) {

		if (!joined) {
				// サービスに加入していなければ値引きなし
//			return null;
//		}else{
//
//
//		 familyNum[0] = record.getFamilyNumber();
//		 if(familyNum[0] != null ){
//			 familyNum[1] = record.getFamilyNumber();
//		 }
//		 return familyNum;
//		}
//	}
//
//	// 単価を計算する
//		public int calcLastPrice(Record record, int basicCallPrice) {
//
//			if (!joined) {
//				// サービスに加入していなければ値引きなし
//				return basicCallPrice;
//			}
//			String PhoneNum = record.getCallNumber();//相手先電話番号取得
//
//
//			if (PhoneNum == familyNum[0] || PhoneNum == familyNum[1]) {
//				// 通話開始時間がサービス対象時間ならば5円引き
//				return basicCallPrice /2;
//			}

			return unitPrice;
		}



//		public void clear() {
//			joined = false;
			if (isFamilyTelNumber(record.getCallNumber())) {
			 	// 家族割引対象の電話番号ならば半額
			 	return unitPrice / 2;
			}

		 return unitPrice;
		}

		 public void clear() {
		 	joined = false;
		 		telNumberCount = 0;
		 	}


}
