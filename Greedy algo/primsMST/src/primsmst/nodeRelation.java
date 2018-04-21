
package primsmst;

//THESE CLASS CONTAINS RELATION IN TERMS OF EDGE WHERE ONE NODE CONNECTED BY ITS PARENT NODE AND WHATS THE COST OF IT
public class nodeRelation {
    int id;
    int parentId;
    int cost;
    
    
   public nodeRelation(){ }
   
   public nodeRelation(int ide){
       id= ide;
       parentId=-1; //-1 MEANS NILL
       cost= 100;    //100 AS INFINITY
   }
   
   public nodeRelation(int i, int pi , int c){
       id = i;
       parentId = pi;
       cost =c;
   }
   
   public String toString(){
       return ": "+id+" parent:"+parentId+" cost:"+cost;
   }
}
