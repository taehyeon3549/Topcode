import java.io.IOException;
import java.util.StringTokenizer;

import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int f =  Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        /* Calendar로 풀이 */
        // Calendar c = Calendar.getInstance();
        // c.set(2021, 9, 17, f, b);
        // c.add(Calendar.MINUTE, -45);

        // Date d = c.getTime();

        // f = d.getHours();
        // b = d.getMinutes();

        // System.out.println(f +" "+ b);

        if(f>= 0 && f<= 23 && b>=0 && b<= 59){
            if(b-45 < 0){
                if(f == 0){
                    f = 23;
                }else{
                    f-=1;
                }
                b = 60 - (45 - b);
            }else{
                b -= 45;
            }
        }

        System.out.println(f + " " + b);

        br.close();
    }
}