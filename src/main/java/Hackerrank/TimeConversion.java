package Hackerrank;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pulsefire
 */
public class TimeConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
            SimpleDateFormat format=new SimpleDateFormat("hh:mm:ss a");
           SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
           Scanner sc=new Scanner(System.in);
           String t=sc.nextLine();
           Date date = null;
           try{
               date=format.parse(t);
           System.out.println(displayFormat.format(date));
           }catch(Exception e)
               {
                  e.printStackTrace();
               }
       }
    
}
