package step8;

public class Nightservice extends TimeService implements Service {

	private boolean joined = false;


	@Override
	public boolean isJoined() {
		return joined;
	}

	@Override
	public void checkService(Record record) {
 		if (record.getServiceCode().equals("E3")) {
  			joined = true;
  		}else{
  			joined = false;
  		}

	}

	@Override
	public boolean isServiceTime(int startHour) {
		 if(joined){
			 //割引対象期間23：00-3：59
			if (23 <= startHour && startHour <= 24) {
				return true;
			} else if(0 <= startHour && startHour <= 3){
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
			// 通話開始時間がサービス対象時間ならば15円引き
			return unitPrice - 15;
		}
		return unitPrice;
	}

	@Override
	public int calcBasicCharge(int basicCharge) {
		if (joined) {
			// サービスに加入していれば基本料金500円増し
			return basicCharge + 500;
		}
		return basicCharge;
	}

	@Override
	public void clear() {
		joined = false;

	}

}
