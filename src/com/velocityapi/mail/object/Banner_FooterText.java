/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velocityapi.mail.object;

/**
 *
 * @author Sandipan
 */
public class Banner_FooterText extends Text  {
    
    int leftPosition=500 ;
    int topPosition=30 ;    

    public int getLeftPosition() {
        return leftPosition;
    }

    public void setLeftPosition(int leftPosition) {
        this.leftPosition = leftPosition;
    }

    public int getTopPosition() {
        return topPosition;
    }

    public void setTopPosition(int topPosition) {
        this.topPosition = topPosition;
    }

    @Override
    public String toString() {
        return "position:absolute;top:" + topPosition + "px;left:" + leftPosition + "px;font-family:" + type + ";font-size:" + size + ";color:" + color + ";";
    }
    
    
    
}
