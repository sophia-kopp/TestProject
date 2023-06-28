import org.junit.jupiter.api.Test;

class Testing {

	@Test
	public void test_DataReader_DataAccessible_returnTrue {
		String stringFromDataBase = DataReader.readFile();
	}

}
