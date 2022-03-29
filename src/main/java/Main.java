public class Main {

    public int numSquares(int n) {

        while (n % 4 == 0) n = n / 4;

        if(n % 4 == 7) return 4;


        for (int i = 0; i * i <=n ; i++) {

            int b = (int) Math.sqrt(n - i * i);

            if(i * i + b * b == n){
                return (i > 0 && b > 0) ? 2 : 1;
            }

        }

        return 3;

    }

}