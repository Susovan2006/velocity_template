/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velocityapi.mail.object;

/**
 *
 * @author Sandipan
 */
public class Text {
    
    String color="black" ;
    String type="arial" ;
    int size=10;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
   @Override
    public String toString() {
        return "font-family:" + type + ";font-size:" + size + ";color:" + color + ";";
    }
    
}
