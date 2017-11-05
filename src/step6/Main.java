package step6;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		DayService dayService = new DayService();
		FamilyService familyService = new FamilyService();
		Invoice invoice = new Invoice();
		InvoiceWriter invoiceWriter = new InvoiceWriter();

		RecordReader recordreader = new RecordReader();
		Record record = recordreader.read();
		while (record != null) {
			switch (record.getRecordCode()) {
			case '1':
				dayService.clear(); // 昼トク割引サービスを初期化する
				familyService.clear();//家族割引サービスを初期化する
				invoice.clear(); // 請求データを初期化する
				invoice.setOwnerTelNumber(record.getOwnerTelNumber());
				break;

			case '2':
				dayService.checkService(record);
				familyService.checkService(record);
				break;

			case '5':
				int unitPrice = 20;
				unitPrice = dayService.calcUnitPrice(record, unitPrice); // 通話単価を求める
				unitPrice = familyService.calcUnitPrice(record, unitPrice);//通話単価を求める（Ｅ１）
				int callTime = record.getCallMinutes();
				int callCharge = unitPrice * callTime;
				invoice.addCallCharge(callCharge);
				break;

			case '9':
				int basicCharge = 1000;
				basicCharge = dayService.calcBasicCharge(basicCharge);
				basicCharge = familyService.calcBasicCharge(basicCharge);
				invoice.setBasicCharge(basicCharge);

				invoiceWriter.write(invoice);

//				writer.write("1 " + ownerTelNumber + "\n");
//				writer.write("5 " + invoice.setBasicCharge(basicCharge)+ "\n");
//				writer.write("7 " + invoice.addCallCharge(callCharge) + "\n");
//				writer.write("9 ====================\n");
				break;
			}

			record = recordreader.read();
		}
		recordreader.close();
		invoiceWriter.close();
	}

}