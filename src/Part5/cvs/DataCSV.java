package Part5.cvs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataCSV {
    private final int id;
    private final String name;
    private final int waterCount;
    private final int gasCount1;
    private final int gasCount2;
    private final int electroCount1;
    private final int electroCount2;

    protected DataCSV(int id, String name, int waterCount, int gasCount1, int gasCount2, int electroCount1, int electroCount2) {
        this.id = id;
        this.name = name;
        this.waterCount = waterCount;
        this.gasCount1 = gasCount1;
        this.gasCount2 = gasCount2;
        this.electroCount1 = electroCount1;
        this.electroCount2 = electroCount2;
    }

    protected boolean isEcological(int maxConsumption) {

        return (this.waterCount < maxConsumption &&
                this.gasCount1 < maxConsumption &&
                this.gasCount2 < maxConsumption &&
                this.electroCount1 < maxConsumption &&
                this.electroCount2 < maxConsumption);
    }

    @Override
    public String toString() {
        return "[id = " + id + ", name = " + name + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getGasCount1() {
        return gasCount1;
    }

    public int getGasCount2() {
        return gasCount2;
    }

    public int getElectroCount1() {
        return electroCount1;
    }

    public int getElectroCount2() {
        return electroCount2;
    }
}


