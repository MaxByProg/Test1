import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbikov on 26.07.2017.
 */
public class Thread1 implements Runnable{
    static String filepath1 = "dep1.xml";
    static String filepath2 = "dep2.xml";
    static List<Integer> salaries1 = new ArrayList<Integer>();
    static List<Integer> salaries2 = new ArrayList<Integer>();
    static List<String> fios1 = new ArrayList<String>();
    static List<String> fios2 = new ArrayList<String>();
    static List<String> result1 = new ArrayList<>();

    public static void thread1() {
        TSCTest1.doIt(filepath1, salaries1, fios1);
        TSCTest1.doIt(filepath2, salaries2, fios2);
    }

        public synchronized void run() {
            thread1();
            int sum1 = TSCTest1.average(salaries1);
            int sum2 = TSCTest1.average(salaries2);
            Algorithm algorithm = Algorithm.getInstance(sum1, sum2, salaries1, fios1, result1);
            try {
                TSCTest1.xmlEncoder(result1, 1);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
            }
        }

}
