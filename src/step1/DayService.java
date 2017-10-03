package step1;

public class DayService {

	private static final String SERVICE_CODE = "E1";

	private static final int BASIC_CHARGE = 200;

	public static String getServiceCode(){

	Main main = new Main();
	String theTime = main.StartCallTime;
		//通話開始が一定の時間内のとき、E1を返す
		if(theTime.compareTo("08:00:00") >= 0 && theTime.compareTo("17:59:00") <= 0){
			return SERVICE_CODE;
		}
			return null;
	}
	//基本料金200＋
	public static int getBasicCharge() {
		return  1000 + BASIC_CHARGE;
	}

	//通話単価５円引き
	public static int getDiscount() {
		return 15;
	}

}
