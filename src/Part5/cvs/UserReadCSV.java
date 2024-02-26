package Part5.cvs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UserReadCSV {
    private final Path path;
    public UserReadCSV(Path path) {
        this.path = path;
    }

    protected static List<String> parseCSV(Path path) {
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

    protected User[] createUsers() {
        List<User> users = new ArrayList<>();
        String separator = "\\|";
        List<String> lines = parseCSV(path);
        for (String s : lines) {
            String[] attributes = s.split(separator);
            User user = newUser(attributes);
            users.add(user);
        }
        return users.toArray(new User[0]);
    }

    protected User newUser(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        int waterCount = Integer.parseInt(metadata[2]);
        int gasCount1 = Integer.parseInt(metadata[3]);
        int gasCount2 = Integer.parseInt(metadata[4]);
        int electroCount1 = Integer.parseInt(metadata[5]);
        int electroCount2 = Integer.parseInt(metadata[6]);

        return new User(id, name, waterCount, gasCount1, gasCount2, electroCount1, electroCount2);
    }


}
