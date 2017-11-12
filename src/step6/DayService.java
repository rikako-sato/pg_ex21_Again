package step6;

public class DayService {

	private boolean joined = false;

	public boolean isJoined() {
		return joined;
	}

	// サービスに加入しているかをチェック
	public void checkService(Record record) {
		if (record.getServiceCode().equals("E1")) {
			joined = true;
		}else{
			joined = false;
		}
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
		}

		if (isServiceTime(record.getStartHour()) ==  true) {
			// 通話開始時間がサービス対象時間ならば5円引き
			return baseUnitPrice - 5;
		}
		return baseUnitPrice;
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
