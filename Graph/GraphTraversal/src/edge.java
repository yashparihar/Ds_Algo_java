
public class edge {
    
    public int fromId;
    public int toId;
    public int cost;
    
    edge(){};
    
    edge(int di,int c, int ti){
        fromId = di;
        toId = ti;
        cost = c;
    }
    
    public void addEdgeSortWise(int di,int c,int ti){
        
    }
    
    
    @Override
   public String toString(){
        return "fromid="+fromId+" Toid="+toId+" cost="+cost;
    }
    
}
