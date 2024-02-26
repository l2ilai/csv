package Part5.cvs;

import java.util.List;

import static Part5.cvs.ReadCSV.parseCSV;

public class Main {
    public static void main(String[] args) {
        ReadCSV csv = new ReadCSV();
        List<DataCSV> dataCSV = csv.newDataCSV(parseCSV());
        InputMaxConsumption input = new InputMaxConsumption();
        int maxConsumption = input.getMaxConsumption();
        for (DataCSV data : dataCSV) {
            if (data.isEcological(maxConsumption)) {
                csv.writeToFile(data);
            }
        }
    }
}

