public class App {
    public static void main(String[] args) throws Exception {

        int n = 500;

        while (n <= 1000) {
            int[] resultado = goldbachConjecture(n);
            if (resultado != null) {
                int primo1 = resultado[0];
                int primo2 = resultado[1];
                System.out.println(n + " = " + primo1 + " + " + primo2);
            }
            n += 2;
        }
        
    }

    public static boolean verificacaoPrimos(int n) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    public static int[] goldbachConjecture(int n) {
        if (n <= 2 || n % 2 != 0) {
            return null;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (verificacaoPrimos(i) && verificacaoPrimos(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }

}
