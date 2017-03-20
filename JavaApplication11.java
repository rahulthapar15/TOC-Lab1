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
    static int sum=0;

    public static void main(String[] args) {
        // TODO code application logic here
    Scanner input = new Scanner(System.in);
        int n,i,count=0;
        System.out.println("enter the number of denominations you will enter");
        n=input.nextInt();
        System.out.println("**************************************************");
        int[] str=new int[n];
        output[index++]="null";
        System.out.println("Insert the denominations one by one");
        str[0]=input.nextInt();
        
        sum=str[0];
        first_state(str[0]);
        for(i=1;i<n;i++){
            str[i]=input.nextInt();
            state_check(str[i]);
            sum= sum + str[i];
            
        }
        if(state==1)
            output[index++]="water";
        if(state==2)
            output[index++]="tea";
        if(state==3)
            output[index++]="coffee";
        if(state==5)
            output[index++]="YOU CAN CHOOSE ANY OF THREE, CHANGE WILL BE GIVEN";
        
         
        System.out.println("You have inserted: Rs." + sum );
        System.out.println("**************************************************");
        System.out.println("States entered are: ");
        for(i=0;i<=n;i++){
           System.out.println(output[i]);        
        }
        System.out.println("**************************************************");
        machine1 callform=new machine1();
        callform.setVisible(true);
        
        
    }
    static void first_state(int str){
        System.out.println("current state="+state);
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
        System.out.println("final state= "+state);
        System.out.println("**************************************************");
    }
    static void state_check(int str){
        
        switch(state){
            case 1:
                System.out.println("current state= "+state);
                output[index++]="water";
               if(str==5)
                   state=2;
               if(str==10)
                   state=4;
               if(str==20)
                   state=5;
               System.out.println("final state= "+state);
               System.out.println("**************************************************");
               break;
            case 2:
                output[index++]="tea";
                System.out.println("current state= "+state);
               if(str==5)
                   state=4;
               if(str==10)
                   state=3;
               if(str==20)
                   state=5;
               System.out.println("final state= "+state);
               System.out.println("**************************************************");
               break;
            case 3:
                output[index++]="coffee";
                System.out.println("current state= "+state);
                if(str==5 || str==10 || str==20)
                state=5;
               System.out.println("final state= "+state);
               System.out.println("**************************************************");
               break;
            case 4:
                output[index++]="null";
                System.out.println("current state= "+state);
               if(str==5)
                   state=3;
               if(str==10 || str==20)
                   state=5;
               System.out.println("final state= "+state);
               System.out.println("**************************************************");
               break;
            case 5:
                output[index++]="YOU CAN CHOOSE ANY OF THREE, CHANGE WILL BE GIVEN";
                System.out.println("current state= "+state);
                if(str==5 || str ==10 || str==20)
                    state=5;
               System.out.println("final state= "+state);
               System.out.println("**************************************************");
                
        }
   
    }
    
}
