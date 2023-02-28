import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main {
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 0) {
                if ((x & 1) == 0) {
                    System.out.println(-1);
                    break;
                } else {
                    cnt++;
                }
            }
            if (i == n - 1) {
                System.out.println(cnt / 2);
            }
        }
    }
}