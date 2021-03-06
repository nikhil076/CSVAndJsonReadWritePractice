package ReadingCSVIntoList;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVreadAndParseTobean {

	private static final String SAMPLE_CSV_FILE_PATH ="./users-with-header.csv";
	
	public static void main(String[] args) 
	{
			Reader reader;
			try {
				reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				

				CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
						.withType(CSVUser.class)
						.withIgnoreLeadingWhiteSpace(true)
						.build();
				
				Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
				
				while(csvUserIterator.hasNext())
				{
					CSVUser csvUser = csvUserIterator.next();
					System.out.println("Name :"+csvUser.getName());
					System.out.println("Email :"+csvUser.getEmail());
					System.out.println("Phone Number :"+csvUser.getPhoneNo());
					System.out.println("Country :"+csvUser.getCountry());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
