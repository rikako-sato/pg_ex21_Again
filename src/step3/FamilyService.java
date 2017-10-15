package step3;

public class FamilyService {


	 String [] familyNum = new String[2];

	private boolean joined = false;

	// サービスに加入しているかをチェック
	public void checkService(String line) {
		if (line.substring(2, 4).equals("C1")) {
			joined = true;
		}

	}
	public int calcBasicCharge(int baseBasicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を100円増し
			return baseBasicCharge + 100;
		}
		return baseBasicCharge;
	}

	//家族の電話番号を取得
	public String[] familyNum(String line){
		if (!joined) {
			// サービスに加入していなければ値引きなし
			return null;
		}


		 familyNum[0] = line.substring(6);
		 if(familyNum[0] != null ){
			 familyNum[1] = line.substring(6);
		 }
		 return familyNum;
	}

	// 単価を計算する
		public int calcLastPrice(String line, int basicCallPrice) {

			if (!joined) {
				// サービスに加入していなければ値引きなし
				return basicCallPrice;
			}
			String PhoneNum = line.substring(24);//相手先電話番号取得


			if (PhoneNum == familyNum[0] || PhoneNum == familyNum[1]) {
				// 通話開始時間がサービス対象時間ならば5円引き
				return basicCallPrice /2;
			}

			return basicCallPrice;
		}


		public void clear() {
			joined = false;
		}


}
