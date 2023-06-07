import java.util.Date;

public class GetDate {

    public static int getDaysBetweenDates(Date date1, Date date2){

        long    difference = date2.getTime() - date1.getTime();


        return (int) (difference / (24*60*60*1000));
    }

}
