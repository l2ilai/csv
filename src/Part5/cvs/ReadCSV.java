package Part5.cvs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static Part5.cvs.DataCSV.createResourceConsumption;


public class ReadCSV {
    protected List<DataCSV> newDataCSV(Path pathToFile) {
        List<DataCSV> list = new ArrayList<>();
        String separator = "\\|";
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            br.readLine();                           //Пропускаем первую строку
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(separator);
                createArrDataCSV(attributes, list);
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private static void createArrDataCSV(String[] attributes, List<DataCSV> list) {
        DataCSV dataCSV = createResourceConsumption(attributes);
        list.add(dataCSV);
    }
}
