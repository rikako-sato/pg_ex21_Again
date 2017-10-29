package step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/invoice.dat"));
		BufferedReader reader = new BufferedReader(new FileReader("data/record.log"));

		//Record record = new Record();

		String ownerTelNumber = null;
		int basicCharge = 0; // 基本料金
		int unitPrice = 0; // 通話単価
		int callCharge = 0; // 通話料金
		DayService dayService = new DayService();
		FamilyService familyService = new FamilyService();

		String line = reader.readLine();
		while (line != null) {
			//char code = line.charAt(0);
			Record record = new Record(line); // line変数をRecordクラスでラッピング
			//switch (code) {
			switch (record.getRecordCode()) {
			case '1':
				basicCharge = 1000; // 基本料金を初期化する
				unitPrice = 20; // 通話単価を初期化する
				callCharge = 0; // 通話料金を初期化する
				dayService.clear(); // 昼トク割引サービスを初期化する
				familyService.clear();//家族割引サービスを初期化する
				ownerTelNumber = record.getOwnerTelNumber();
				//ownerTelNumber = line.substring(2);
				break;

			case '2':
				dayService.checkService(record);
				familyService.checkService(record);
				familyService.familyNum(record);
				break;

			case '5':
				int calcUnitPrice = dayService.calcUnitPrice(record, unitPrice); // 通話単価を求める
				int calcLastPrice = familyService.calcLastPrice(record,calcUnitPrice);//通話単価を求める（Ｅ１）
				//int callTime = Integer.parseInt(line.substring(19, 21));
				int callTime = record.getCallMinutes();
				callCharge += calcLastPrice * callTime;



				break;

			case '9':
				basicCharge = dayService.calcBasicCharge(basicCharge)+familyService.calcBasicCharge(basicCharge); // 基本料金を求める

				writer.write("1 " + ownerTelNumber + "\n");
				writer.write("5 " + basicCharge + "\n");
				writer.write("7 " + callCharge + "\n");
				writer.write("9 ====================\n");
				break;
			}

			line = reader.readLine();
		}
		reader.close();
		writer.close();
	}

}