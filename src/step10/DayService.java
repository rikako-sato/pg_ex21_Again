package step10;

public class DayService extends TimeService {

	public boolean isServiceTime(int startHour) {
		 if(isJoined()){
			if (8 <= startHour && startHour <= 17) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getServiceCode() {
		return "E1";
	}

	@Override
	public int getDiscount() {
		return 5;
	}

	@Override
	public int getBasicCharge() {
		return 200;
	}

}
