package step10;

public class ServiceCollection implements Service {

	DayService dayService = new DayService();
	FamilyService familyService = new FamilyService();
	NightService nightService = new NightService();
	MorningService morningService = new MorningService();

	Service[] services = {dayService, nightService, morningService, familyService};

	public void checkService(Record record){
		for (Service service : services) {
			service.checkService(record);
		}
	}

	public int calcBasicCharge(int basicCharge) {
		for (Service service : services) {
			basicCharge = service.calcBasicCharge(basicCharge);
		}
		return basicCharge;

	}

	public int calcUnitPrice(Record record, int unitPrice) {
		for (Service service : services) {
			unitPrice = service.calcUnitPrice(record, unitPrice);
		}
		return unitPrice;
	}

	public void clear() {
		for (Service service : services) {
			service.clear();
		}
	}

}


