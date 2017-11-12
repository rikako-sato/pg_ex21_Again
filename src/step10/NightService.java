package step10;

public class NightService extends TimeService {

	@Override
	public boolean isServiceTime(int startHour) {
		if(isJoined()){
			 //割引対象期間23：00-3：59
			if (23 <= startHour || 0 <= startHour && startHour <= 3) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getServiceCode() {
		return "E2";
	}

	@Override
	public int getDiscount() {
		return 5;
	}

	@Override
	public int getBasicCharge() {
		return 500;
	}


}
