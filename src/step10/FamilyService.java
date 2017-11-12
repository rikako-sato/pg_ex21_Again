package step10;

public class FamilyService implements Service{

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

	public int calcBasicCharge(int basicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金を100円増し
			basicCharge += 100;
		}
		return basicCharge;
	}

	// 単価を計算する
	public int calcUnitPrice(Record record, int unitPrice) {
		if (!joined) {
			return unitPrice;
		}
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
