package step8;

public abstract class TimeService {

	public abstract void clear();

	public abstract boolean isJoined();

	public abstract  boolean isServiceTime(int startHour);

	public abstract  void checkService(Record record);

	public abstract  int calcUnitPrice(Record record, int unitPrice);

	public abstract int calcBasicCharge(int basicCharge);


}
