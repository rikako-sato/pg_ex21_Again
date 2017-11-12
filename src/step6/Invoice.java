package step6;

public class Invoice {

	String ownerTelnumber = null;
	int basicCharge = 0;
	int callCharge = 0;

	//契約者の番号をかえす
	public String getOwnerTelNumber() {
		return ownerTelnumber ;
	}

	//基本料金をかえす
	public int getBasicCharge() {
		return basicCharge ;
	}

	//通話料金を返す
	public int getCallCharge() {
		return callCharge;
	}

	//契約者の番号をmainより取得
	public void setOwnerTelNumber(String ownerTelNumber) {
		this.ownerTelnumber = ownerTelNumber;
	}
	//main クラスよりbasicChargeを取得
	public void setBasicCharge(int basicCharge) {
		this.basicCharge = basicCharge;
	}
	//main クラスよりcallChargeを取得
	public void addCallCharge(int callCharge) {
		this.callCharge += callCharge;
	}

	public void clear() {
		 ownerTelnumber = null;
		 basicCharge = 0;
		 callCharge = 0;
	}

}
