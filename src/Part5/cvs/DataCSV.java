package Part5.cvs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataCSV {
    static boolean isTitleWrite = false;
    private final int id;
    private final String name;
    private final int waterCount;
    private final int gasCount1;
    private final int gasCount2;
    private final int electroCount1;
    private final int electroCount2;

    private DataCSV(int id, String name, int waterCount, int gasCount1, int gasCount2, int electroCount1, int electroCount2) {
        this.id = id;
        this.name = name;
        this.waterCount = waterCount;
        this.gasCount1 = gasCount1;
        this.gasCount2 = gasCount2;
        this.electroCount1 = electroCount1;
        this.electroCount2 = electroCount2;
    }

    protected static DataCSV createResourceConsumption(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        int waterCount = Integer.parseInt(metadata[2]);
        int gasCount1 = Integer.parseInt(metadata[3]);
        int gasCount2 = Integer.parseInt(metadata[4]);
        int electroCount1 = Integer.parseInt(metadata[5]);
        int electroCount2 = Integer.parseInt(metadata[6]);

        return new DataCSV(id, name, waterCount, gasCount1, gasCount2, electroCount1, electroCount2);
    }

    protected boolean isEcological(int maxConsumption) {
        return (this.waterCount < maxConsumption &&
                this.gasCount1 < maxConsumption &&
                this.gasCount2 < maxConsumption &&
                this.electroCount1 < maxConsumption &&
                this.electroCount2 < maxConsumption);
    }

    protected void writeToFile(File file) {
        String title = "id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2\n";
        String data = this.id + "|" + this.name + "|" + this.waterCount +
                "|" + this.gasCount1 + "|" + this.gasCount2 + "|" + this.electroCount1 +
                "|" + this.electroCount2 + "\n";
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

    @Override
    public String toString() {
        return "[id = " + id + ", name = " + name + "]";
    }

}


