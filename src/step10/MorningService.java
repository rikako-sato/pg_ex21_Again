package step10;

public class MorningService  extends TimeService implements Service {

	private boolean joined = false;


	@Override
	public boolean isJoined() {
		return joined;
	}

	@Override
	public void checkService(Record record) {
 		if (record.getServiceCode().equals("E2")) {
  			joined = true;
  		}else{
  			joined = false;
  		}

	}

	@Override
	public boolean isServiceTime(int startHour) {
		 if(joined){
			 //割引対象期間6：00-7：59
			if (6 <= startHour && startHour <= 7) {
				return true;
			}
		}
			return false;
	}



	@Override
	public int calcUnitPrice(Record record, int unitPrice) {
		if (!joined) {
			// サービスに加入していなければ値引きなし
			return unitPrice;
		}
		if (isServiceTime(record.getStartHour()) ==  true) {
			// 通話開始時間がサービス対象時間ならば10円引き
			return unitPrice - 10;
		}
		return unitPrice;
	}

	@Override
	public int calcBasicCharge(int basicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金200円増し
			return basicCharge + 200;
		}
		return basicCharge;
	}

	@Override
	public void clear() {
		joined = false;

	}


}
