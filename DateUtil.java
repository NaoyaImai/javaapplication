/*
    練習問題4,8,10,12~18をすべてまとめたクラス
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {

    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    static final int MONDAY = 2;
    static final int FRIDAY = 6;

    //練習問題4
    public static void addDate(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("日付を入力してください (yyyy/MM/dd): ");
        String inputDate = scanner.next(); // コマンドラインから日付を読み取ります。
        System.out.print("加算する日数を整数で入力してください: ");
        int daysToAdd = Integer.parseInt(scanner.next()); // コマンドラインから日付を読み取ります。

        try {
            Date date = AddDate.validateAndParseDate(inputDate);
            Date newDate = AddDate.addDaysToDate(date, daysToAdd);
            System.out.println("新しい日付: " + sdf.format(newDate));
        } catch (ParseException e) {
            System.err.println("エラー: 日付の形式が正しくありません。");
        }
        scanner.close();

    }
    public static Date validateAndParseDate(String inputDate) throws ParseException {
        if (!inputDate.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
            throw new ParseException("Invalid date format", 0);
        }
        sdf.setLenient(false);

        return sdf.parse(inputDate);
    }

    //練習問題4ここまで

    //練習問題8
    public static List<String> getLastMonthDates(String yyyymmdd) throws ParseException {
        List<String> list = new ArrayList<>();
        String result;
        Date date = validateAndParseDate(yyyymmdd);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Date d1;

        Calendar endcal = Calendar.getInstance();
        endcal.setTime(date);

        endcal.add(Calendar.MONTH, -1);
        endcal.add(Calendar.DATE, -1);

        while(cal.after(endcal)){

            d1 = cal.getTime();

            result = String.valueOf(sdf.format(d1));
            list.add(result);
            cal.add(Calendar.DATE, -1);
        }

        return list;
    }   

    public static void main(String[] args) throws ParseException {
        String inputDate = "2023/04/26";
        List<String> dateList = getLastMonthDates(inputDate);
        System.out.println(dateList);
    }

    //練習問題8ここまで


    //練習問題12
    public static boolean isWeekday(String yyyymmdd) throws ParseException {
        try {
            Date date = validateAndParseDate(yyyymmdd);

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            boolean bool = true ;

            int Weekday = cal.get(Calendar.DAY_OF_WEEK);
                /*DAY_OF_WEEKでの返り値
                    日曜日 = 1
                    月曜日 = 2
                    火曜日 = 3
                    水曜日 = 4
                    木曜日 = 5
                    金曜日 = 6
                    土曜日 = 7
                */

            bool = Weekday >= MONDAY && Weekday <= FRIDAY;


            return bool;
        } catch (Exception e) {
            System.err.println("エラー: 日付の形式が正しくありません。");
            return false;
        }

    }
    //練習問題13
    public static boolean isSundayOrSaturday(String yyyymmdd) throws ParseException {

        boolean bool = true;

        boolean b = bool != isWeekday(yyyymmdd);


        return b;

    }

    //練習問題17(From,to含める)
    public static int countWorkingDays(String from, String to) throws ParseException {
        String[] daysString = getDaysStrBetween(from, to);
        int count = 0;

        for(int i = 0; i < daysString.length; i++){
            if(isWeekday(daysString[i])){
                count++;
            }
        }



        return count;
    }

    //指定された日付間の日にちを取得する関数(From,to含める)
    public static String[] getDaysStrBetween(String from, String to) throws ParseException {

        List list = new ArrayList<>();
        Date fromdate = AddDate.validateAndParseDate(from);
        Date todate = AddDate.validateAndParseDate(to);
        Date d1;

        Calendar stcal = Calendar.getInstance();
        stcal.setTime(fromdate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(todate);
        endCal.add(Calendar.DATE, 1);
        while (stcal.before(endCal)){
            d1 = stcal.getTime();
            String result = String.valueOf(sdf.format(d1));
            list.add(result);
            stcal.add(Calendar.DATE,1);
        }


        String[] days = (String[]) list.toArray(new String[list.size()]);

        //System.out.println(Arrays.toString(days));
        return days;
    }

    //練習問題18
    public static String getNextWeekday(String yyyymmdd) throws  ParseException {
        String nextWeekdays = null;
        Date date = validateAndParseDate(yyyymmdd);
        Date d_tmp;
        String s_tmp = null;




        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        while(true){
            d_tmp = cal.getTime();
            s_tmp = String.valueOf(sdf.format(d_tmp));

            if(isWeekday(s_tmp)){
                break;
            }
            cal.add(Calendar.DATE,1);
        }
        nextWeekdays = s_tmp;
        return nextWeekdays;
    }
    public static int getDaysBetweenDates(Date date1, Date date2){

        Calendar c_date1 = Calendar.getInstance();
        c_date1.setTime(date1);

        Calendar c_date2 = Calendar.getInstance();
        c_date2.setTime(date2);

        c_date1.clear(Calendar.HOUR);
        c_date1.clear(Calendar.MINUTE);
        c_date1.clear(Calendar.SECOND);
        c_date1.clear(Calendar.MILLISECOND);
        c_date1.set(Calendar.HOUR_OF_DAY,0);

        long difference = c_date2.getTimeInMillis() - c_date1.getTimeInMillis();

        System.out.println(c_date2.getTime()+ "::" + c_date1.getTime());
        //System.out.println("ans = "+(int) (difference/ (24*60*60*1000)));

        return (int) (difference / (24*60*60*1000));
    }


}





