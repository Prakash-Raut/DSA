package recursion;

public class PowerFunction {

    public static int power(int a, int b) {
        if (b == 0) return 1;
        return (power(a, b - 1) * a);
    }

    public static int fastPower(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return fastPower(a * a, b / 2);
        return a * fastPower(a, b - 1);
    }

    public static double fastPowerWithModulo(double a, int b, int m) {
        if (b < 0) {
            a = (1 / a);
            b = -b;
        }
        if (b == 0) return 1;
        if (b % 2 == 0) return fastPowerWithModulo((a * a) % m, b / 2, m);
        return (a * fastPowerWithModulo(a, b - 1, m) % m) % m;
    }


    public static void main(String[] args) {
        System.out.println("power(5, 4) = " + power(5, 4));
        System.out.println("fastPower(5, 4) = " + fastPower(5, 4));
        int m = (int) (1e9 + 7);
        System.out.println("fastPowerWithModulo(5,4,m) = " + fastPowerWithModulo(5, 4, m));
    }
}
