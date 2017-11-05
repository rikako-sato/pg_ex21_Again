package step6;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Test;

public class RecordReaderTest {

	@Test
	public void readTest() throws Exception {

		RecordReader recordReader = new RecordReader(new StringReader(""));
		assertNull(recordReader.read());
		recordReader = new RecordReader(new StringReader("a"));
		assertNotNull(recordReader.read());
		assertNull(recordReader.read());
		recordReader.read();

//		String filename = RecordReader.class.getClassLoader().getResource("data/record.log").getPath();
//		RecordReader file = RecordReader(filename);


	}

}
