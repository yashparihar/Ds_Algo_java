
import java.util.*;


public class aniruddhaAndHackerearth {

   public static void main(String args[] ) throws Exception {
      
        //Scanner
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            
            int tot =0;
            
            tot= ( tot + (1 + dfs(n , false , 2)) ) % 1000000007;  //(N , lastdigit , level  )
            tot= ( tot + (1 + dfs(n , true , 2)) ) % 1000000007;
            
            System.out.println(tot);
            
        }
        
    }
    
    public static int dfs(int n, boolean lastDigit , int level){
        
        if (level>n) return 0;
        
        level++;
        int tot = 0;
        
        if (false || lastDigit)
            tot = (tot + 1 + dfs(n , false , level )) % 1000000007;
            
            tot = (tot + 1 + dfs(n , true , level)) %   1000000007; // as true||anthing is true
        
        return tot;
        
        
    }
    
}
