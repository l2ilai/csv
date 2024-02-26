package Part5.cvs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserWriterCSV {
    private final File file;

    public UserWriterCSV(File file) {
        this.file = file;
    }

    protected void writeToFile(User[] ecoUsers) {
        String title = "id|name|waterCount|gasCount1|gasCount2|electroCount1|electroCount2\n";
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)) {
            fileOutputStream.write(title.getBytes());
            for (User user : ecoUsers) {
                String data = user.getId() + "|" + user.getName() + "|" + user.getWaterCount() +
                        "|" + user.getGasCount1() + "|" + user.getGasCount2() + "|" + user.getElectroCount1() +
                        "|" + user.getElectroCount2() + "\n";
                fileOutputStream.write(data.getBytes());
                System.out.println(data + " <- записан в файл");
            }
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
}
