package JavaProjects.GUITrials;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class db {
    
    final String pathString = "./db.csv";

   public void write(ArrayList<DataEntryCsv> data) throws Exception {
    try (Writer writer  = new FileWriter(pathString)) {

        StatefulBeanToCsv<DataEntryCsv> sbc = new StatefulBeanToCsvBuilder<DataEntryCsv>(writer)
          .withQuotechar('\'')
          .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
          .build();

        sbc.write(data);
    }
   }

   public ArrayList<DataEntryCsv> read() throws Exception {
    Path path = Paths.get(pathString);
    Reader reader = Files.newBufferedReader(path); 
        List<DataEntryCsv> beans = new CsvToBeanBuilder<DataEntryCsv>(reader)
            .withType(DataEntryCsv.class)
            .build()
            .parse();
            return new ArrayList<DataEntryCsv>(beans);

}
}
