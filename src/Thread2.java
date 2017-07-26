import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbikov on 26.07.2017.
 */
public class Thread2 implements Runnable {
    static String filepath1 = "dep1.xml";
    static String filepath2 = "dep2.xml";
    static List<Integer> salaries1 = new ArrayList<Integer>();
    static List<Integer> salaries2 = new ArrayList<Integer>();
    static List<String> fios1 = new ArrayList<String>();
    static List<String> fios2 = new ArrayList<String>();
    static List<String> result2 = new ArrayList<>();

    public static void thread2() {
        TSCTest1.doIt(filepath1, salaries1, fios1);
        TSCTest1.doIt(filepath2, salaries2, fios2);
    }

    public synchronized void run() {
        thread2();
        int sum1 = TSCTest1.average(salaries1);
        int sum2 = TSCTest1.average(salaries2);
        Algorithm algorithm = Algorithm.getInstance(sum2, sum1, salaries1, fios1, result2);
        try {
            TSCTest1.xmlEncoder(result2, 2);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
