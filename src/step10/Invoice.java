package step10;

public class Invoice {

//	String setownerTelnumber = null;
//	String getownerTelnumber = null;
//	int setBasicCharge = 0;
//	int getBasicCharge = 0;
//	int setCallCharge = 0;
//	int getCallCharge = 0;
	String ownerTelnumber = null;
	int basicCharge = 0;
	int callCharge = 0;
	//契約者の番号をかえす
	public String getOwnerTelNumber() {

//		getownerTelnumber = setownerTelnumber;
//		return getownerTelnumber ;
		return ownerTelnumber ;
	}
	//基本料金をかえす
	public int getBasicCharge() {
//		getBasicCharge = setBasicCharge;
//		return getBasicCharge ;
		return basicCharge ;
	}
	//電話料金を返す
//	public Object getCallCharge() {
//		getCallCharge = setCallCharge + getCallCharge;
//		return getCallCharge;
	//通話料金を返す
	public int getCallCharge() {
	 	return callCharge;
	}

	//契約者の番号をmainより取得
//	public void setOwnerTelNumber(Record record) {
//		setownerTelnumber = record.getOwnerTelNumber();
	public void setOwnerTelNumber(String ownerTelNumber) {
		this.ownerTelnumber = ownerTelNumber;
	}
	//main クラスよりbasicChargeを取得
//	public int setBasicCharge(int basicCharge) {
//		setBasicCharge = basicCharge;
//		return setBasicCharge;
	public void setBasicCharge(int basicCharge) {
		this.basicCharge = basicCharge;
	}
	//main クラスよりcallChargeを取得
//	public int addCallCharge(int callCharge) {
//		setCallCharge = callCharge;
//		return setCallCharge;
	public void addCallCharge(int callCharge) {
		 this.callCharge += callCharge;

	}

	public void clear() {
//		 setownerTelnumber = null;
//		 getownerTelnumber = null;
//		 setBasicCharge = 0;
//		 getBasicCharge = 0;
//		 setCallCharge = 0;
//		 getCallCharge = 0;
		 ownerTelnumber = null;
		 basicCharge = 0;
		 callCharge = 0;

	}



}
