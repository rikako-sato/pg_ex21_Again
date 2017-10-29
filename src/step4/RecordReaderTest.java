package step4;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordReaderTest {

	@Test
	public void readTest() throws Exception {
		RecordReader recordReader = new RecordReader();

		assertNull(recordReader.read());

//		String filename = RecordReader.class.getClassLoader().getResource("data/record.log").getPath();
//		RecordReader file = RecordReader(filename);


	}

}
