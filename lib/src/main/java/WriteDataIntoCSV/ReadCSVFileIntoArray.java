package WriteDataIntoCSV;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSVFileIntoArray {
	
	private static final String SAMPLE_CSV_FILE_PATH = "./users.csv";
	
	private static void main(String[] args) throws IOException, CsvValidationException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException
	{
		try 
		{
			Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
			StatefulBeanToCsv<ContactDetail> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.build();
			List<ContactDetail> contactDetails = new ArrayList<>();
			contactDetails.add(new ContactDetail("Sundar pichai", "sundar.pichai@gmail.com", "+1-11111111", "India"));
			contactDetails.add(new ContactDetail("new name", "abc@gmail.com", "+1-22222222", "England"));
			
			beanToCsv.write(contactDetails);
		}
		catch (IOException e) {
		}
	}

}
