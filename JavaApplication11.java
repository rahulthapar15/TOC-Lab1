/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author simranagarwal
 */
import static java.lang.System.exit;
import java.util.*;
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    static int state=0;
    static String[] output=new String[20];
    static int index=0;

    public static void main(String[] args) {
        // TODO code application logic here
    Scanner input = new Scanner(System.in);
        int n,i,sum=0,count=0;
        System.out.println("enter the number of denominations you will enter");
        n=input.nextInt();
        int[] str=new int[n];
        output[index++]="null";
        System.out.println("Insert the denominations one by one");
        str[0]=input.nextInt();
        first_state(str[0]);
        for(i=1;i<n;i++){
            str[i]=input.nextInt();
            state_check(str[i]);
            sum+=str[i];
            
        }
        if(state==1)
            output[index++]="water";
        if(state==2)
            output[index++]="tea";
        if(state==3)
            output[index++]="coffee";
        if(state==5)
            output[index++]="ALL THREE, CHANGE GIVEN";
        System.out.println("You have inserted: Rs." + sum + "and you can buy:" );
        for(i=0;i<=n;i++){
            System.out.println(output[i]);        
        }
        
    }
    static void first_state(int str){
       
        if(str==5){
            state=1;
        }
        else if(str==10){
            state=2;
        }
        else if(str==20){
            state=3;
        }
        else{
            System.out.println("invalid input");
            exit(0);
        }
      
    }
    static void state_check(int str){
        switch(state){
            case 1:
                System.out.println(state);
                output[index++]="water";
               if(str==5)
                   state=2;
               if(str==10)
                   state=4;
               if(str==20)
                   state=5;
               break;
            case 2:
                output[index++]="tea";
                System.out.println(state);
               if(str==5)
                   state=4;
               if(str==10)
                   state=3;
               if(str==20)
                   state=5;
               break;
            case 3:
                output[index++]="coffee";
                System.out.println(state);
                if(str==5 || str==10 || str==20)
                state=5;
               break;
            case 4:
                output[index++]="null";
                System.out.println(state);
               if(str==5)
                   state=3;
               if(str==10 || str==20)
                   state=5;
               break;
            case 5:
                output[index++]="ALL THREE, CHANGE GIVEN";
                System.out.println(state);
                if(str==5 || str ==10 || str==20)
                    state=5;
        }
   
    }
    
}
