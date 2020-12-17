/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.SpringContext;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import org.springframework.web.multipart.MultipartFile;

 


/**
 *
 * @author vaggelis
 */
public class HelperMethods {

    private CreditDebitCardServiceInterface getCreditDebitCardService() {
        return SpringContext.getBean(CreditDebitCardServiceInterface.class);
    }

    private MyUserServiceInterface getMyUserService() {
        return SpringContext.getBean(MyUserServiceInterface.class);
    }

    public static Date parseStringToDate(String s) {

        Date date = null;
        try {
            DateFormat inputFormat = new SimpleDateFormat(
                    "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
            date = inputFormat.parse(s);
            System.out.println(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;

    }


//    public static MultipartFile convertBase64ToMultipart(String encodedString) {
//
//        byte[] byteBase64Decoded = Base64.getDecoder().decode(encodedString);
//        String stringBase64Decoded = new String(byteBase64Decoded);
//
//        return BASE64DecodedMultipartFile.base64ToMultipart(stringBase64Decoded);
//
//    }

    public static String manipulateDateString(String requestString) {
        String[] parts = requestString.split("GMT ", 2);
        String part1 = parts[0]; // 004
        String part2 = parts[1]; // 034556-42
        return (part1 + "GMT+" + part2);


        
        
    }
}
