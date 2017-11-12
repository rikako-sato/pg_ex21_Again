package step8;

public class ServiceCollection implements Service {

	private String Normal;
	private String E1;
	private String C1;
	public Object code;

	DayService dayService = new DayService();
	FamilyService familyService = new FamilyService();

	Service[] services = {dayService, familyService};

	public void checkService(Record record) {
		for(Service service : services) {
			service.checkService(record);
		}
	}

	public int calcBasicCharge(int basicCharge) {
		for(Service service : services) {
			basicCharge = service.calcBasicCharge(basicCharge);
		}
		return basicCharge;
	}

	public int calcUnitPrice(Record record, int unitPrice) {
		for(Service service : services) {
			unitPrice = service.calcUnitPrice(record, unitPrice);
		}
		return unitPrice;
	}

	public void clear() {
		for(Service service : services) {
			service.clear();
		}
	}

}


