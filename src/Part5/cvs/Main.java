package Part5.cvs;

public class Main {
    public static void main(String[] args) {
        PathToFile pathToFile = new PathToFile();
        UserReader readerCSV = new UserReadCSV(pathToFile.getInPath());
        InputMaxConsumption input = new InputMaxConsumption();
        UserFilter ecoFilter = new UserEcoFilter(input.getMaxConsumption());
        UserWriter writerCSV = new UserWriterCSV(pathToFile.getOutPath());

        User[] inputData = readerCSV.read();
        User[] ecoUsers = ecoFilter.filter(inputData);
        writerCSV.writeToFile(ecoUsers);
    }
}

