package step5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/invoice.dat"));


		String ownerTelNumber = null;
		int basicCharge = 0; // 基本料金
		int unitPrice = 0; // 通話単価
		int callCharge = 0; // 通話料金
		DayService dayService = new DayService();
		FamilyService familyService = new FamilyService();
		Invoice invoice = new Invoice();

		RecordReader recordreader = new RecordReader();
		Record record = recordreader.read();
		while (record != null) {
			//char code = line.charAt(0);

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
				writer.write("5 " + invoice.setBasicCharge(basicCharge)+ "\n");
				writer.write("7 " + invoice.addCallCharge(callCharge) + "\n");
				writer.write("9 ====================\n");
				break;
			}

			record = recordreader.read();
		}
		recordreader.close();
		writer.close();
	}

}