package utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by nguyen.hoai.duc on 6/27/2016.
 */
public class FileUtils {
    public String coventerTime(String date) {
        String dateFormat = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = format.parse(date);
            long mTime = d.getTime();
            Date mDate = new Date(mTime);
            DateFormat format2 = new SimpleDateFormat("HH:mm");
            dateFormat = format2.format(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat;
    }
    public String coventerDate(String date) {
        String dateFormat = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = format.parse(date);
            long mTime = d.getTime();
            Date mDate = new Date(mTime);
            DateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
            format2.setLenient(false);
            dateFormat = format2.format(mDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat;
    }

    public BigDecimal getRound(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }
}
