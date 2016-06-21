package DivideandConquer;

/**
 *
 * @author Balram
 */
public class CalcPower {

    public static double power(double x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return power(x, y / 2) * power(x, y / 2);
        } else {
            if (y > 0) {
                return x*(power(x, y / 2) * power(x, y / 2));       //2*2*2
            } else {
                return (power(x, y / 2) * power(x, y / 2)) / x;     // 1/2*1/2*1/2
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(power(2, -3));

    }

}
