import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        int result = 0;

        if(year % 4 == 0){
            if(year % 100 != 0 || year % 400 == 0){
                result = 1;                
            }
        }
        System.out.println(result);        
    }
}