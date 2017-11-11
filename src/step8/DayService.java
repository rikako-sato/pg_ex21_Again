package step8;

public class DayService implements Service {

	private boolean joined = false;

	public boolean isJoined() {
 		return joined;
	}

	// サービスに加入しているかをチェック
//	 	public boolean checkService(Record record) {
//	 		if (record.getServiceOption().equals("E1")) {
	 	public void checkService(Record record) {
	 		if (record.getServiceCode().equals("E1")) {
	  			joined = true;
	  		}else{
	  			joined = false;
	  		}
//	 		return joined;

	  	}


	public int calcBasicCharge(int basicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を200円増し
			return basicCharge + 200;
		}
		return basicCharge;
	}



	// 単価を計算する
	public int calcUnitPrice(Record record, int unitPrice) {

		if (!joined) {
			// サービスに加入していなければ値引きなし
			return unitPrice;
//		}else{

		}

//		if (isServiceTime(record) ==  true) {
		if (isServiceTime(record.getStartHour()) ==  true) {
			// 通話開始時間がサービス対象時間ならば5円引き
			return unitPrice - 5;
		}

		return unitPrice;
//		}
	}

	public void clear() {
		joined = false;
	}

//	public boolean isServiceTime(Record record) {
//		int startHour = record.getStartHour(); // 通話開始時間
//		if(joined == true){
	public boolean isServiceTime(int startHour) {
		 if(joined){
			if (8 <= startHour && startHour <= 17) {
				return true;
			}
		}
			return false;
	}






}
