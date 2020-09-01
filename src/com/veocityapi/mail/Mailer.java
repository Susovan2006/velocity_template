/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veocityapi.mail;

/**
 *
 * @author Sandipan
 */

import com.velocityapi.mail.object.Table;
import com.velocityapi.exception.VelocityAPIException ;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import java.util.List ;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.Multipart;
import javax.mail.internet.MimeMultipart;
import javax.activation.FileDataSource ;
import javax.activation.DataHandler;
import java.io.File;

public class Mailer extends MailerBean
{
    VelocityEngine ve=null ;
    VelocityContext context = null;
    Template template = null;
    StringWriter writer = null;
    Properties properties=null;
    List<Table> tableList=null ;
    Multipart mp = null;
    public Mailer() throws VelocityAPIException{        
        properties= new Properties();
        ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());        
        tableList=new ArrayList<Table>() ;
        context = new VelocityContext();
        writer = new StringWriter();  
        mp = new MimeMultipart();
        try{
        ve.init(); 
        }
        catch(Exception e){
            throw new VelocityAPIException("Failed to initialize the Velocity Engine");
        }
        try{
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName));
        }
         catch(Exception e){
            throw new VelocityAPIException("Failed to load the properties file");
        } 
        
    }
    
   
    
   private void createMail() throws VelocityAPIException{
        context.put("headerRowColor", headerRowColor);        
        context.put("bannerText", bannerText);  
        context.put("footerText", footerText);  
        context.put("bannerImage", bannerImage);  
        context.put("footerImage", footerImage);  
        context.put("bannerTextStyle", bannerTextStyle); 
        context.put("footerTextStyle", footerTextStyle); 
        context.put("bannerStyle", bannerStyle); 
        context.put("footerStyle", footerStyle);  
        context.put("mailBodyContent", mailBodyContent);        
        context.put("tableList", tableList);    
       try{
        template = ve.getTemplate(templateName);        
       }
        catch(Exception e){
             throw new VelocityAPIException("Failed to load the email template ");
       }
       try{        
        template.merge( context, writer );
       }
        catch(Exception e){
             throw new VelocityAPIException("Failed to create the E-mail ");
       }      
      
                                                        }
   
    public void sendMail (String subject,String receipent) throws VelocityAPIException { 
   sendMail(subject,properties.getProperty("mail.sender.username").trim(),properties.getProperty("mail.sender.password").trim(),receipent,properties.getProperty("mail.from"));		
                                                                          }
     public void sendMail (String subject,List<String> receipentList) throws VelocityAPIException {
      String receipents="";  
      for(String receipent : receipentList){
      receipents= receipents + receipent + "," ;   
      }  
      receipents=receipents.substring(0, receipents.lastIndexOf(","));
      System.out.println(receipents);
      sendMail(subject,properties.getProperty("mail.sender.username").trim(),properties.getProperty("mail.sender.password").trim(),receipents,properties.getProperty("mail.from"));		
                                                                            }
     
      public void sendMail (String subject,String toReceipent,String ccReceipent) throws VelocityAPIException { 
   sendMail(subject,properties.getProperty("mail.sender.username").trim(),properties.getProperty("mail.sender.password").trim(),toReceipent,ccReceipent,properties.getProperty("mail.from"));		
                                                                          }
     public void sendMail (String subject,List<String> toReceipentList,List<String> ccReceipentList) throws VelocityAPIException {
      String toReceipents=""; 
      String ccReceipents=""; 
      
      for(String receipent : toReceipentList){
      toReceipents= toReceipents + receipent + "," ;   
      }
      
      for(String receipent : ccReceipentList){
      ccReceipents= ccReceipents + receipent + "," ;   
      }
      toReceipents=toReceipents.substring(0, toReceipents.lastIndexOf(","));
      ccReceipents=ccReceipents.substring(0, ccReceipents.lastIndexOf(","));      
      sendMail(subject,properties.getProperty("mail.sender.username").trim(),properties.getProperty("mail.sender.password").trim(),toReceipents,ccReceipents,properties.getProperty("mail.from"));		
                                                                            }
   
    public void sendMail (String subject,String uname,String pwd,String toReceipent,String frm) throws VelocityAPIException  {        
    sendMail (subject,uname,pwd,toReceipent,"",frm);
    }
   
    public void sendMail (String subject,String uname,String pwd,String toReceipent,String ccReceipent ,String frm) throws VelocityAPIException  {        
        final String username=uname;
        final String password=pwd;      
        final String from=frm;       
        createMail(); 
        
		Session session = Session.getDefaultInstance(properties,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});		
			Message message = new MimeMessage(session);                       
                        MimeBodyPart imagePart1 = new MimeBodyPart();
                        MimeBodyPart imagePart2 = new MimeBodyPart();
                        MimeBodyPart htmlPart = new MimeBodyPart();                                          
                        FileDataSource img_footer = new FileDataSource(this.getClass().getClassLoader().getResource(footerImage).getFile());
                        FileDataSource img_banner = new FileDataSource(this.getClass().getClassLoader().getResource(bannerImage).getFile());  
                        try{
                        htmlPart.setContent(writer.toString(),"text/html");
                        imagePart1.setDataHandler(new DataHandler(img_banner));
                        imagePart2.setDataHandler(new DataHandler(img_footer));                        
                        imagePart1.setHeader("Content-ID", "<banner>");
                        imagePart2.setHeader("Content-ID", "<footer>");                       
                        mp.addBodyPart(imagePart1);
                        mp.addBodyPart(imagePart2);
                        mp.addBodyPart(htmlPart);                      
                        message.setContent(mp);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toReceipent));
                        message.setRecipients(Message.RecipientType.CC,
			InternetAddress.parse(ccReceipent));
			message.setSubject(subject);			
			Transport.send(message); 
                        }
                        catch(Exception e){
                         throw new VelocityAPIException("Failed to send the E-mail ");   
                        }
	}
    
    
     public void addTable(Table table) throws VelocityAPIException{         
        tableList.add(table);    
        for(List<String> row : table.getData())  
        {
            if(row.size()>table.getHeader().size())
                throw new VelocityAPIException("Header Coloumn less than Data coloumn");
        }            
        
    }    
    
   public void addAttachments(List<String> attachments) throws VelocityAPIException{         
        List<String> failedAttachments=new ArrayList<String>();       
        for(String attachment : attachments)  
        {
            
         MimeBodyPart attachmentPart = new MimeBodyPart();
         FileDataSource source = new FileDataSource(attachment);
         try{
         attachmentPart.setDataHandler(new DataHandler(source));
         attachmentPart.setFileName(new File(attachment).getName());
         mp.addBodyPart(attachmentPart);
         }
         catch(Exception e){
             System.out.println("Failed to attach");
          failedAttachments.add(attachment);   
         }
        }
         if(failedAttachments.size()>0)
            throw new VelocityAPIException("Failed to add the attachments:" + failedAttachments.toString());                  
        
    }   
  
   public void addAttachment(String attachment) throws VelocityAPIException{
       List<String> attachments=new ArrayList<String>();
       attachments.add(attachment);
       addAttachments(attachments);
   }
   
    
}
