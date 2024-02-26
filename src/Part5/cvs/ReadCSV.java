package Part5.cvs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private static boolean isTitleWrite = false;
    private static final PathToFile PATH_TO_FILE = new PathToFile();
    protected static List<String> parseCSV() {
        Path path = PATH_TO_FILE.getInPath();
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            br.readLine();                           //Пропускаем первую строку
            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    protected List<DataCSV> newDataCSV(List<String> list) {
        List<DataCSV> listCSV = new ArrayList<>();
        String separator = "\\|";
        for (String s : list) {
            String[] attributes = s.split(separator);
            DataCSV dataCSV = createDataCSV(attributes);
            listCSV.add(dataCSV);
        }
        return listCSV;
    }

    protected DataCSV createDataCSV(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        int waterCount = Integer.parseInt(metadata[2]);
        int gasCount1 = Integer.parseInt(metadata[3]);
        int gasCount2 = Integer.parseInt(metadata[4]);
        int electroCount1 = Integer.parseInt(metadata[5]);
        int electroCount2 = Integer.parseInt(metadata[6]);

        return new DataCSV(id, name, waterCount, gasCount1, gasCount2, electroCount1, electroCount2);
    }

    protected void writeToFile(DataCSV csv) {
        File file = PATH_TO_FILE.getOutPath();
        String title = "id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2\n";
        String data = csv.getId() + "|" + csv.getName() + "|" + csv.getWaterCount() +
                "|" + csv.getGasCount1() + "|" + csv.getGasCount2() + "|" + csv.getElectroCount1() +
                "|" + csv.getElectroCount2() + "\n";
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            if (!isTitleWrite) {
                fileOutputStream.write(title.getBytes());
                isTitleWrite = true;
            }
            fileOutputStream.write(data.getBytes());
            System.out.println(data + " <- записан в файл");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
