package Part5.cvs;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class PathToFile {
    private Path path;
    private static String readStr() {
        String line = null;
        Scanner s = new Scanner(System.in);
        System.out.println("Введите путь до файла: ");
        if (s.hasNextLine()) {
            line = s.nextLine();
        }
        s.reset();
        return line;
    }
    protected Path getInPath() {
        String line = readStr();
        path = Paths.get(line);
        System.out.println("Путь: " + path);
        return path;
    }
    protected File getOutPath() {
        String str = path.getParent() + "\\outData.csv";
        return Paths.get(str).toFile();
    }
}
// E:\programs\data.csv