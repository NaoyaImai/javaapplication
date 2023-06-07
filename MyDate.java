import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyDate {

    static final int MONDAY = 2;
    static final int FRIDAY = 6;

    static final int SUNDAY = 1;

    static final int SATURDAY = 7;


    //練習問題12
    public static boolean isWeekday(String yyyymmdd) throws ParseException {
        try {
            Date date = AddDate.validateAndParseDate(yyyymmdd);

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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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

        System.out.println(Arrays.toString(days));
        return days;
    }

    //練習問題18
    public static String getNextWeekday(String yyyymmdd) throws  ParseException {
        String nextWeekdays = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = AddDate.validateAndParseDate(yyyymmdd);
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


    /*public static String[] getNationalHoliday(int yyyy) throws JsonProcessingException {
        String responseBody = getResponseBodyTo("https://holidays-jp.github.io/api/v1/2023/date.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);
    }


     */
}
