package step6;

public class FamilyService {

	private String[] telNumbers = new String[2];
	private int telNumberCount = 0;


	private boolean joined = false;

	public boolean isJoined() {
		return joined;
	}

	// サービスに加入しているかをチェック
	public void checkService(Record record) {
		if (record.getServiceCode().equals("C1")) {
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

	public int calcBasicCharge(int baseBasicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を100円増し
			return baseBasicCharge + 100;
		}
		return baseBasicCharge;
	}

	// 単価を計算する
	public int calcUnitPrice(Record record, int basicCallPrice) {
		if (!joined) {
			// サービスに加入していなければ値引きなし
			return basicCallPrice;
		}
		if (isFamilyTelNumber(record.getCallNumber())) {
			// 家族割引対象の電話番号ならば半額
			return basicCallPrice / 2;
		}
		return basicCallPrice;
	}

	public void clear() {
		joined = false;
		telNumberCount = 0;
	}


}
