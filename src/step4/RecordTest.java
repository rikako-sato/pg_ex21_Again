package step4;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordTest {

	@Test
	public void RecordCodeTest() {
		Record record = new Record("2 C1 090-1234-0002");
		assertEquals('2', record.getRecordCode());
	}

	@Test
	public void OwnerTelNumberTest() {
		Record record = new Record("1 090-1234-0001");
		assertEquals("090-1234-0001", record.getOwnerTelNumber());
	}

	@Test
	public void ServiceCodeTest() {
		Record record = new Record("2 C1 090-1234-0002");
		assertEquals("C1", record.getServiceCode());
	}

	@Test
	public void ServiceOptionTest1() {
		Record record = new Record("2 C1 090-1234-0002");
		assertEquals("090-1234-0002", record.getServiceOption());
	}
	@Test
	public void ServiceOptionTest2() {
		Record record = new Record("2 E1");
		assertNull(record.getServiceOption());
	}

	@Test
	public void getStartHourTest() {
		Record record = new Record("5 2004/06/06 12:34 007 090-1234-0003");
		assertEquals(12, record.getStartHour());
	}

	@Test
	public void CallMinutesTest() {
		Record record = new Record("5 2004/06/06 12:34 007 090-1234-0003");
		assertEquals(7, record.getCallMinutes());
	}

	@Test
	public void CallNumberTest() {
		Record record = new Record("5 2004/06/06 12:34 007 090-1234-0003");
		assertEquals("090-1234-0003", record.getCallNumber());
	}
}
