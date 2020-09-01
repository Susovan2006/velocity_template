/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velocityapi.mail.object;

import java.util.List ;

/**
 *
 * @author Sandipan
 */
public class Table {
    
    List<String> header=null ;
    List<List<String>> data=null ;
    String oddRowColor="red" ;
    String evenRowColor="green" ;
    String tableDescription="Sample Table" ;
    String tableDescriptionStyle="" ;
    
    public List<List<String>> getData() {
        return data;
    }
    
 public void setData(List<List<String>> data) {
        this.data = data;
    }
 
    public String getTableDescriptionStyle() {
        return tableDescriptionStyle;
    }

    public void setTableDescriptionStyle(Text textStyle) {
        this.tableDescriptionStyle = textStyle.toString();
    }

    public String getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }

   

    public String getEvenRowColor() {
        return evenRowColor;
    }

    public void setEvenRowColor(String evenRowColor) {
        this.evenRowColor = evenRowColor;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public String getOddRowColor() {
        return oddRowColor;
    }

    public void setOddRowColor(String oddRowColor) {
        this.oddRowColor = oddRowColor;
    }
    
    
    
    
}
