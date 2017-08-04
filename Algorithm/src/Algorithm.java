
import java.util.*;

/**
 * Created by mbikov on 26.07.2017.
 */
public class Algorithm {
    private static volatile Algorithm instance;

    private Algorithm(int i1, int i2, List<Integer> l, List<String> f, List<String> r) {
        for (int i = 0; i < l.size(); i++) {
            int a = l.get(i);
            if (a < i1 && a > i2) {
                r.add(f.get(i) + " переходит в другой отдел ");
            }
        }
    }

    public static Algorithm getInstance(int i1, int i2, List<Integer> l, List<String> f, List<String> r) {
        Algorithm localinstance = instance;
        if(localinstance == null) {
            synchronized (Algorithm.class) {
                localinstance = instance;
                    if(localinstance == null) {
                        instance = localinstance = new Algorithm(i1, i2, l, f, r);
                    }
            }
        }
        return localinstance;
    }
}
