public class IsPrime {
    private int numero;
    private boolean numeroPrimo;

    public boolean trovaNumeriPrimi(int numero) {
        if (numero == 0) {
            numeroPrimo = false;
        } else if (numero == 1) {
            numeroPrimo = true;
        }
        if (numero == 2) {
            numeroPrimo = true;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                numeroPrimo = false;
                break;
            }
            if (numero % i != 0) {
                numeroPrimo = true;
            }
        }
        return numeroPrimo;
    }
}
