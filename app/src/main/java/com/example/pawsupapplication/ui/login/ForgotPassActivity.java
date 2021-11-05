package com.example.pawsupapplication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pawsupapplication.MainActivity;
import com.example.pawsupapplication.R;
import com.example.pawsupapplication.data.DAO;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ForgotPassActivity extends AppCompatActivity {

    String sendEmail;
    String sendPassword;
    String currentOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
    }
    public void verifyEmail(View view){
        boolean emailExists=false;
        EditText resetEmail = findViewById(R.id.resetEmail);
        String stringEmail=resetEmail.getText().toString();
        DAO database = new DAO(view.getContext());
        Map<String, ArrayList<String>> users = database.getUsers();
        if(!users.isEmpty()) {
            emailExists=(users.get(stringEmail)!=null);
        }
        if(emailExists) {
            //uniqueEmail=(users.get(stringEmail)==null);
            Toast.makeText(getApplicationContext(), "Aye: "+stringEmail, Toast.LENGTH_SHORT).show();

            System.out.println("Account found");
            sendEmail="pawsupincapp@gmail.com";
            sendPassword="Pawsup12!";

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sendEmail, sendPassword);
                }
            });


            try {
                Message message= new MimeMessage(session);
                message.setFrom(new InternetAddress(sendEmail));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(stringEmail));
                message.setSubject("PawsUp Recovery Code");
                message.setContent("<table width='100%' style='width:100%;border-spacing:0px' border='0' cellpadding='0' cellspacing='0'>\n" +
                        "                <tbody>                    \n" +
                        "                    <tr>" +
                        "                        <td></td>\n" +
                        "                        <td align='center' width='600'>\n" +
                        "                            <img style='width: 7em;height: 7em;' src='https://pawsupinc.com/static/media/Logo.1d5ea0e8.png' alt='Pawsup Logo'><br>\n" +
                        "                            <table border='0' cellpadding='0' cellspacing='0' width='100%' style='border-spacing:0px' bgcolor='#ffffff'>\n" +
                        "                                <tbody>\n" +
                        "                                    <tr>\n" +
                        "                                        <td align='center'>Your 6 digit recovery code is: "+ String.valueOf(generateOTP(6))+"\n" +
                        "                                        \n" +
                        "                                        </td>\n" +
                        "                                    </tr>\n" +
                        "                                    <br>\n" +
                        "                                </tbody>\n" +
                        "                            </table>\n" +
                        "                        </td>\n" +
                        "                        <td><br></td>\n" +
                        "                    </tr>\n" +
                        "                </tbody>\n" +
                        "            </table>", "text/html; charset=utf-8");

                new SendMail().execute(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }


        }
        else{
            Toast.makeText(getApplicationContext(), "Sorry, this email has not been registered", Toast.LENGTH_SHORT).show();
        }
    }

    private class SendMail extends AsyncTask<Message, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Sending Email, please wait", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "sent";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("sent")){
                Toast.makeText(getApplicationContext(), "Email Sent", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_reset_password_otp);

            }
            else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private char[] generateOTP(int length) {
        String numbers = "1234567890";
        Random random = new Random();
        char[] otp = new char[length];

        for(int i = 0; i< length ; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        currentOTP=String.valueOf(otp);
        return otp;
    }
}