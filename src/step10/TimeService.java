package step10;

abstract class TimeService implements Service {
	// 割引サービスに加入しているか
	private boolean joined = false;

	// 変数を初期化する
	public void clear() {
		joined = false;
	}

	// 割引サービスに加入済み
	public void joined() {
		joined = true;
	}

	// 割引サービスに加入しているか
	public boolean isJoined() {
		return joined;
	}

	// 割引対象時間かどうかを判定する
	abstract public boolean isServiceTime(int hour);

	// 割引サービスに加入しているかを検査する
	public void checkService(Record record) {
		if (getServiceCode().equals(record.getServiceCode())) {
			joined();
		}
	}

	// サービスコード
	abstract public String getServiceCode();

	// 単価を計算する
	public int calcUnitPrice(Record record, int unitPrice) {
		int hour = record.getStartHour();
		if (isServiceTime(hour)) {
			// 割引
			unitPrice -= getDiscount();
		}
		return unitPrice;
	}

	// 割引額を取り出す
	abstract public int getDiscount();

	//	基本料金を計算する
	public int calcBasicCharge(int basicCharge) {
		if (isJoined()) {
			basicCharge += getBasicCharge();
		}
		return basicCharge;
	}

	// 基本料金を取り出す
	abstract public int getBasicCharge();
}
