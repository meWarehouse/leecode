public class Main {


    public int reverseBits(int n) {

        n = n >>> 16 | n << 16;

        n = n >>> 8 & 0x00ff00ff | (n & 0x00ff00ff)



    }

}