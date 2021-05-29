package com.at.jz;

/**
 * @author zero
 * @create 2021-05-22 17:45
 */
public class JZ12 {

    public double Power(double base, int exponent) {


        if(exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        double x = base;
        double res = 1.0;

        while (exponent != 0){
            if((exponent&1) != 0){
                res *= x;
            }
            x *= x;
            exponent>>=1;
        }

        return res;
    }


    public double Power1(double base, int exponent) {

        if(exponent < 0){
            base = 1 / base;
            exponent = -exponent;
        }

        return Npower(base,exponent);
    }

    public double Npower(double base, int exponent) {

        if(exponent == 0) return 1.0D;

        double res = Npower(base,exponent/2);

        if(exponent % 2 == 1){
            return res * res * base;
        }else {
            return res * res;
        }

    }
}
