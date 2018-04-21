/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primsmst;

public class adjacentNode{
   public int id;
   public int cost;
    
   public adjacentNode(){}
    
    public adjacentNode(int i, int c){
        id = i;
        cost = c;
    }
    
    
 
   public String toString(){
       return " "+id+" cost: "+cost;
   }
    
}