import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by mbikov on 26.07.2017.
 */
public class Thread1 implements Runnable{
        public void run() {
            TSCTest1.doIt(TSCTest1.filepath1, TSCTest1.salaries1, TSCTest1.fios1);
            TSCTest1.doIt(TSCTest1.filepath2, TSCTest1.salaries2, TSCTest1.fios2);
            int sum1 = TSCTest1.average(TSCTest1.salaries1);
            int sum2 = TSCTest1.average(TSCTest1.salaries2);
            Algorithm.getInstance(sum1, sum2, TSCTest1.salaries1, TSCTest1.fios1, TSCTest1.result1);
            try {
                TSCTest1.xmlEncoder(TSCTest1.result1, 1);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            }
        }

}
