
package primsmst;

import java.util.LinkedList;

//THIS CLASS CONTAINS NODES DETAILS LIKE NODE NUMBER AND LIST OF ALL ADJACENT NODES
public class NODE {
    
    
   public int id;
   public LinkedList adjacentnode = new LinkedList<adjacentNode>();
   // adjacentNode adjacentnode[] ;
    
    
   public NODE(){}
   
   public NODE(int i, int nc[][]){ 
       id=i;
       
       for(int m=0;m<nc[0].length; m++){
           int ide = nc[0][m];
           int cost = nc[1][m];
           adjacentnode.add( new adjacentNode( ide , cost) );
           
         }
       }
   
     
    public void adjacenttoString(){
        for(int i=0;i<adjacentnode.size() ; i++){
            adjacentNode ed=(adjacentNode) adjacentnode.get(i);
            System.out.println(" "+ed.toString());
        }
    }
   

   }

  
   
   


