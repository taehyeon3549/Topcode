import java.util.StringTokenizer;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));        

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        if(f==s){
            bw.write("=="+"\n");
        }else{
            bw.write(f<s ? "<" : ">");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    
}
