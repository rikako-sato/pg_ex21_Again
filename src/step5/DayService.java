package step5;

public class DayService {

	private boolean joined = false;

	// サービスに加入しているかをチェック
	public boolean checkService(Record record) {
		if (record.getServiceOption().equals("E1")) {
			joined = true;
		}else{
			joined = false;
		}
		return joined;

	}

	public int calcBasicCharge(int baseBasicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を200円増し
			return baseBasicCharge + 200;
		}
		return baseBasicCharge;
	}



	// 単価を計算する
	public int calcUnitPrice(Record record, int baseUnitPrice) {

		if (!joined) {
			// サービスに加入していなければ値引きなし
			return baseUnitPrice;
		}else{



		if (isServiceTime(record) ==  true) {
			// 通話開始時間がサービス対象時間ならば5円引き
			return baseUnitPrice - 5;
		}

		return baseUnitPrice;
		}
	}

	public void clear() {
		joined = false;
	}

	public boolean isServiceTime(Record record) {
		int startHour = record.getStartHour(); // 通話開始時間
		if(joined == true){
			if (8 <= startHour && startHour <= 17) {
				return true;
			}
		}
			return false;
	}






}
