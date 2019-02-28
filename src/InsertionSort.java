import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String readString() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c))
            c = read();
        do {
            stringBuilder.append(c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}

public class InsertionSort {

    public static void main(String[] args) throws IOException,InterruptedException {
        final InputReader reader =new InputReader(System.in);
        final Solver solver= new Solver();
        final StringBuilder stringBuilder=new StringBuilder();
        final int n=reader.readInt(), a[]=new int[n];
        for (int i = 0; i < n ; i++) {
            a[i]=reader.readInt();
        }
        stringBuilder.append(Arrays.toString(solver.solve(a))).append('\n');
        System.out.println(stringBuilder);

    }
}

class Solver {
    public int[] solve(final int a[]) {
        final int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int max = Integer.MIN_VALUE, index = -1;
            for (int j = 0; j < a.length ; j++) {
                if(max<a[j]){
                    max=a[j];
                    index=j;
                }
            }
            b[b.length-1-i]=max;
            a[index]=Integer.MIN_VALUE;
        }
        return b;
    }
}