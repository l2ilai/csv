package Part5.cvs;

public class Main {
    public static void main(String[] args) {
        PathToFile pathToFile = new PathToFile();
        UserReadCSV readerCSV = new UserReadCSV(pathToFile.getInPath());
        InputMaxConsumption input = new InputMaxConsumption();
        UserEcoFilter ecoFilter = new UserEcoFilter(input.getMaxConsumption());
        UserWriterCSV writerCSV = new UserWriterCSV(pathToFile.getOutPath());

        User[] inputData = readerCSV.createUsers();
        User[] ecoUsers = ecoFilter.filter(inputData);
        writerCSV.writeToFile(ecoUsers);
    }
}

