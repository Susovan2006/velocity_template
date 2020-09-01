/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velocityapi.mail.object;

/**
 *
 * @author Sandipan
 */
public class Banner_Footer {
    
    String backgroundColor="white" ;
    int width=1366 ;
    int height=120 ;

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

   

     @Override
    public String toString() {
        return "position:relative;width:" + width + "px;height:" + height + "px;background-color::" + backgroundColor + ";";
    }
    
    
}
