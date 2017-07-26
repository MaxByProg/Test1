
import java.util.*;

/**
 * Created by mbikov on 26.07.2017.
 */
public class Algorithm {
    private static Algorithm instance;

    private Algorithm(int i1, int i2, List<Integer> l1, List<String> f1, List<String> r) {
        for (int i = 0; i < l1.size(); i++) {
            int a = l1.get(i);
            if (a < i1 && a > i2) {
                r.add(f1.get(i) + " переходит в другой отдел ");
            }
        }
    }

    public static synchronized Algorithm getInstance(int i1, int i2, List<Integer> l1, List<String> f1, List<String> r) {
        if(instance == null) {
            instance = new Algorithm(i1, i2, l1, f1, r);
        }
        return instance;
    }
}
