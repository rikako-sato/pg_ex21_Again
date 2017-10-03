package step0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/invoice.dat"));
		BufferedReader reader = new BufferedReader(new FileReader("data/record.log"));

		String ownerTelNumber = null;
		int basicCharge = 0; // 基本料金
		int unitPrice = 0; // 通話単価
		int callCharge = 0; // 通話料金

		String line = reader.readLine();
		while (line != null) {
			char code = line.charAt(0);

			switch (code) {
			case '1':
				basicCharge = 1000; // 基本料金を初期化する
				unitPrice = 20; // 通話単価を初期化する
				callCharge = 0; // 通話料金を初期化する
				ownerTelNumber = line.substring(2);
				break;

			case '5':
				int callTime = Integer.parseInt(line.substring(19, 21));
				callCharge += unitPrice * callTime;
				break;

			case '9'://書き込み
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
