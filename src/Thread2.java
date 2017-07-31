import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbikov on 26.07.2017.
 */
public class Thread2 implements Runnable {

    public void run() {
        TSCTest1.doIt(TSCTest1.filepath1, TSCTest1.salaries1, TSCTest1.fios1);
        TSCTest1.doIt(TSCTest1.filepath2, TSCTest1.salaries2, TSCTest1.fios2);
        int sum1 = TSCTest1.average(TSCTest1.salaries1);
        int sum2 = TSCTest1.average(TSCTest1.salaries2);
        Algorithm.getInstance(sum2, sum1, TSCTest1.salaries2, TSCTest1.fios2, TSCTest1.result2);
        try {
            TSCTest1.xmlEncoder(TSCTest1.result2, 2);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
