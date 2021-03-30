import java.math.*;

public class CityBlock extends ComputeDistance {
    double sum;
    double first_term = 1;
    double i = 1;
    private double d;
    private double p;
    private double q;
    private double n;

    public static int sigma(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += 1;
        }
        return sum;
    }

    public double cityBlockEq() {
        d = sum(Math.abs(q//interval - p//interval));
        return 0;
    }

    public static class Sigma {
        public static void main(String[] args) {
            int sum = sigma(3);
            System.out.println(sum);
        }
    }
}
}
