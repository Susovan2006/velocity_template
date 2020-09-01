/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velocityapi.main;

/**
 *
 * @author Sandipan
 */


import com.velocityapi.mail.object.Banner_FooterText;
import com.velocityapi.mail.object.Table;
import com.veocityapi.mail.Mailer;
import java.util.ArrayList;
import java.util.List ;


public class APITest {
    public static void main( String[] args )
        throws Exception
    {
       
        List<String> header = new ArrayList<String>();
         header.add("Coloumn1");
         header.add("Coloumn2");
         header.add("Coloumn3");
         header.add("Coloumn4");
        List<String> row1 = new ArrayList<String>();
         row1.add("data1");
         row1.add("data2");
         row1.add("data3");
         row1.add("data4");
         List<String> row2 = new ArrayList<String>();
         row2.add("data1");
         row2.add("data2");
         row2.add("data3");
         row2.add("data4");
         List<String> row3 = new ArrayList<String>();
         row3.add("data1");
         row3.add("data2");
         row3.add("data3");
         row3.add("data4");
         List<String> row4 =new ArrayList<String>();
         row4.add("data1");
         row4.add("data2");
         row4.add("data3");
         row4.add("data4");
        
         List<List<String>> data = new ArrayList<List<String>>();
         data.add(row1);
         data.add(row2);
         data.add(row3);
         data.add(row4);
        Table tb=new Table();
        tb.setData(data);
        tb.setHeader(header);  
        tb.setEvenRowColor("purple");
        Mailer ob1=new Mailer();
        Banner_FooterText bt=new Banner_FooterText();
        bt.setColor("brown");
        bt.setLeftPosition(250);
        bt.setTopPosition(40);
        
        ob1.setBannerTextStyle(bt);        
        ob1.setBannerText("Sample Mail");
        ob1.addTable(tb);
        ob1.addTable(tb);
        List names1=new ArrayList<String>();
        List names2=new ArrayList<String>();
        names1.add("b_sandipan1990@rediffmail.com");
        names2.add("sandipan.bera@gmail.com");
        /*names.add("sandipan.bera@yahoo.in");
        names.add("sandipan.bera@cognizant.com");*/
        ob1.addAttachment("C:\\Users\\Sandipan\\Desktop\\receipt.pdf");
        ob1.sendMail("My Mail",names1,names2);
        
    }
    
   
}
