/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.*;

/**
 *
 * @author Yash
 */
public class NewClass {
   
    
    static class demo {
        int x;
        int y;
        
        demo(int i,int j){
            x=i;
            y=j;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final demo other = (demo) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }
        
        
        
    }
    
    public static void main(String arhsp[]){
        
        
        
        HashMap<demo , Integer> map=new HashMap() ;
        demo m = new demo(4,1);
        map.put( m , 23);
        
        if ( map.get(new demo(4,1)) != null )
            System.out.println(map.hashCode() );
       
            
        
    }
}
