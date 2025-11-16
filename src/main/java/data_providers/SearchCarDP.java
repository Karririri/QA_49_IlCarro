package data_providers;

import org.testng.annotations.DataProvider;
import utils.PropertiesReader;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchCarDP {

    @DataProvider(name = "searchCarDataFromFile")
    public Iterator<Object[]> searchCarDataFromFile() {
        List<Object[]> list = new ArrayList<>();
        String fileName = PropertiesReader.getProperty("base.properties", "file_search_car_csv");

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/test/resources/data_csv" + File.separator + fileName)
        )) {
            String line = br.readLine(); // пропускаем заголовок, если есть
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String city = split[0];
                LocalDate dateFrom = LocalDate.parse(split[1], formatter);
                LocalDate dateTo = LocalDate.parse(split[2], formatter);
                list.add(new Object[]{city, dateFrom, dateTo});
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IO exception");
        }
        return list.iterator();
    }
}

