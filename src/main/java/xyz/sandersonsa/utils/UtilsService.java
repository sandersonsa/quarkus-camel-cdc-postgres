package xyz.sandersonsa.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UtilsService {

     // c= create, u= update, d= delete, r= snapshot
     private final String OPERATION_INSERT = "c";
     private final String OPERATION_UPDATE = "u";
     private final String OPERATION_DELETE = "d";
    

    public LocalDateTime convertToLocalDateTime(String date) {
        // Fri Nov 25 21:00:00 BRT 2022
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        // String date = "Tuesday, Aug 16, 2016 12:10:56 PM";
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        System.out.println(localDateTime);
        System.out.println(formatter.format(localDateTime));
        return localDateTime;
    }

    public Date convertToDate(String str) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd
        // HH:mm:ss zzz yyyy", Locale.US);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
