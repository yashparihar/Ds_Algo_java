
package datastructure;

import java.util.Scanner;


public class LinkedList {

    int size;
    Node head;
    Node last;
    
    LinkedList(){
        size=0;
        head=null;  last=null;
    }
    
    void insertFirst(int value){
        Node newNode=new Node(value,this.head);
        
        if (this.head==null){
        this.last=newNode;
        }
        this.head=newNode;
        size++;
        
    }
    
    void insertLast(int value){
        Node newNode=new Node(value,null);
        
        if (this.head==null)
            this.head=newNode;
         else
            this.last.setNext(newNode); 
        
        this.last=newNode;
        size++;
    }
    
    boolean isEmpty(){
        if (head==null) return true;
        else return false;
    }
    
    Node deleteFirst(){
        Node del=this.head;
        
        if (head==last) {
            head=null;  last=null;  }
        else 
            this.head=this.head.getNext();  
        
            size--;
            return del;
    }
    
     Node deleteLast(){  size--;
       Node current=this.head;
       Node del=null;
       
       if (head==last){
           del=head;
            head=null; last=null;
           return del;
       }
           
         while(current.getNext().getNext()!=null){
            current=current.getNext();
          }
        
          del=current.getNext();
           current.setNext(null);
           this.last=current;
          
        return del;
    }
   
    
   public void display(){
        Node current=this.head;
        if (this.isEmpty()){
            System.out.println("Empty list");
            return;
        }
        
        while(current!=null){
            System.out.print(current.value+"  ");
            current=current.getNext();
        }
    }
    
    public static void main(String args[]){
     LinkedList list=new LinkedList();
      Scanner sc=new Scanner(System.in);  
      
      out:
      while(true){
           System.out.println();
            System.out.println("1.Insert first");
            System.out.println("2.Insert last");
            System.out.println("3.delete first");
            System.out.println("4.delete last");
            
            switch(sc.nextInt()){     
            case 1:
                System.out.println("Enter value");
                list.insertFirst(sc.nextInt());
                break; 
            case 2:
                 System.out.println("Enter value");
                list.insertLast(sc.nextInt());
                break;
            case 3:
                if (list.isEmpty())
                    System.out.println("List is empty");
                 else
                    System.out.println("deleted Node :"+list.deleteFirst().getValue());
                
                break;
            case 4:
                   if (list.isEmpty())
                    System.out.println("List is empty");
                 else
                    System.out.println("deleted Node :"+list.deleteLast().getValue());
                
                break;
            default:
                System.out.println("Wrong Choice exit");
                break out;
        }
            
          System.out.println("Size: "+list.size+ "; Values: ");  
          list.display();  
        }
    }
    
}
