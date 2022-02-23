package gcdMath;

public class GcdFile {

    public int gcdFunction(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdFunction(b, a % b);
    }
}// public class GcdFile
