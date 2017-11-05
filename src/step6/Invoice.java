package step6;

public class Invoice {

	String setownerTelnumber = null;
	String getownerTelnumber = null;
	int setBasicCharge = 0;
	int getBasicCharge = 0;
	int setCallCharge = 0;
	int getCallCharge = 0;
	//契約者の番号をかえす
	public String getOwnerTelNumber() {

		getownerTelnumber = setownerTelnumber;

		return getownerTelnumber ;
	}
	//基本料金をかえす
	public int getBasicCharge() {
		getBasicCharge = setBasicCharge;
		return getBasicCharge ;
	}
	//電話料金を返す
	public Object getCallCharge() {
		getCallCharge = setCallCharge + getCallCharge;
		return getCallCharge;
	}

	//契約者の番号をmainより取得
	public void setOwnerTelNumber(Record record) {
		setownerTelnumber = record.getOwnerTelNumber();


	}
	//main クラスよりbasicChargeを取得
	public int setBasicCharge(int basicCharge) {
		setBasicCharge = basicCharge;
		return setBasicCharge;

	}
	//main クラスよりcallChargeを取得
	public int addCallCharge(int callCharge) {
		setCallCharge = callCharge;
		return setCallCharge;

	}

	public void clear() {
		 setownerTelnumber = null;
		 getownerTelnumber = null;
		 setBasicCharge = 0;
		 getBasicCharge = 0;
		 setCallCharge = 0;
		 getCallCharge = 0;
	}



}
