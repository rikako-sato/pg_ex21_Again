package step8;

public class DayService implements Service {

	private boolean joined = false;

	public boolean isJoined() {
 		return joined;
	}

	// サービスに加入しているかをチェック
	public void checkService(Record record) {
		if (record.getServiceCode().equals("E1")) {
			joined = true;
		}
	}


	public int calcBasicCharge(int basicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を200円増し
			basicCharge += 200;
		}
		return basicCharge;
	}

	// 単価を計算する
	public int calcUnitPrice(Record record, int unitPrice) {

		if (!joined) {
			// サービスに加入していなければ値引きなし
			return unitPrice;
		}

		if (isServiceTime(record.getStartHour())) {
			// 通話開始時間がサービス対象時間ならば5円引き
			return unitPrice - 5;
		}

		return unitPrice;
	}

	public void clear() {
		joined = false;
	}

	public boolean isServiceTime(int startHour) {
		 if(joined){
			if (8 <= startHour && startHour <= 17) {
				return true;
			}
		}
		return false;
	}






}
