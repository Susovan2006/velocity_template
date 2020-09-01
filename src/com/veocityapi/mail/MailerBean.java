/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veocityapi.mail;

import com.velocityapi.mail.object.Banner_FooterText;

/**
 *
 * @author Sandipan
 */
public class MailerBean {    
   
    String headerRowColor="blue" ;
    String bannerImage="images/banner.jpg";
    String footerImage="images/footer.jpg";
    String bannerText="My Mail" ;
    String footerText="© 2013-2015 First Data. All rights reserved." ;
    String templateName="templates/email.vm";
    String bannerTextStyle="position:absolute;top:30px;left:500px;" ;
    String footerTextStyle="position:absolute;top:30px;left:500px;color:white;" ;
    String mailBodyContent="" ;
    String propertiesFileName="configuration/config.properties";
    String bannerStyle="position:relative;";
    String footerStyle="position:relative;width:1366px;height:20px;background-color:#47A4BE;";
    
    public String getFooterText() {
        return footerText;
    }

    public void setFooterText(String footerText) {
        this.footerText = footerText;
    }
    
    public String getBannerImage() {
        return bannerImage;
    }

    public String getMailBodyContent() {
        return mailBodyContent;
    }

    public void setMailBodyContent(String mailBodyContent) {
        this.mailBodyContent = mailBodyContent;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getBannerText() {
        return bannerText;
    }

    public void setBannerText(String bannerText) {
        this.bannerText = bannerText;
    }

    public String getBannerTextStyle() {
        return bannerTextStyle;
    }

    public void setBannerTextStyle(Banner_FooterText textStyle) {
        this.bannerTextStyle = textStyle.toString();
    } 

    public String getFooterImage() {
        return footerImage;
    }

    public void setFooterImage(String footerImage) {
        this.footerImage = footerImage;
    }

    public String getHeaderRowColor() {
        return headerRowColor;
    }

    public void setHeaderRowColor(String headerRowColor) {
        this.headerRowColor = headerRowColor;
    }


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getPropertiesFileName() {
        return propertiesFileName;
    }

    public void setPropertiesFileName(String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    public String getBannerStyle() {
        return bannerStyle;
    }

    public void setBannerStyle(String bannerStyle) {
        this.bannerStyle = bannerStyle;
    }

    public String getFooterStyle() {
        return footerStyle;
    }

    public void setFooterStyle(String footerStyle) {
        this.footerStyle = footerStyle;
    }

    public String getFooterTextStyle() {
        return footerTextStyle;
    }

    public void setFooterTextStyle(String footerTextStyle) {
        this.footerTextStyle = footerTextStyle;
    }

   
    
    
    
}
