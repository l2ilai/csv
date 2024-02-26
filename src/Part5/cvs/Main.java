package Part5.cvs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PathToFile path = new PathToFile();
        ReadCSV csv = new ReadCSV();
        InputMaxConsumption input = new InputMaxConsumption();
        List<DataCSV> dataCSV = csv.newDataCSV(path.getInPath());
        int maxConsumption = input.getMaxConsumption();
        for (DataCSV data : dataCSV) {
            if (data.isEcological(maxConsumption)) {
                data.writeToFile(path.getOutPath());
            }
        }
    }
}

