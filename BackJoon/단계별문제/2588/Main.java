import java.io.*;

public class Main {
    /** 첫번째 작성한 코드 
     * Convert String to Integer And calculate index number of String 
     * **/
    // public static void main(String[] args) throws Exception{        
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    //     String f = br.readLine();
    //     String s = br.readLine();

    //     for(int i = s.length()-1; i>=0; i--){            
    //         bw.write(Integer.parseInt(f) * Integer.parseInt(String.valueOf(s.charAt(i)))+"\n");    
    //     }
    //     bw.write(Integer.parseInt(f)*Integer.parseInt(s)+"\n");

    //     br.close();
    //     bw.flush();
    //     bw.close();
    // }    
    
    /** 두번째 작성한 코드
     * 입력 받을때 바로 Integer.parse 하여 % 와 / 로 계산
     */
    public static void main(String[] args) throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int f = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());

        bw.write(f*(s%10)+"\n");
        bw.write(f * ((s/10)%10) + "\n");
        bw.write(f * (s/100) + "\n");
        bw.write(f * s+"\n");

        br.close();
        bw.flush();
        bw.close();
    }    
}
