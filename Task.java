import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.BaseStream;


public class Task {
    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    static final Calendar toDay = Calendar.getInstance();

    private Calendar calendar;
    private String name;
    private Date d_today = new Date();
    private Date d_cal = new Date();

    int actualMinuteTime = 0;
    int scheduleTime = 0;

    Status status;

    public Task (String name, String yyyymmdd) throws ParseException {
        Date date = AddDate.validateAndParseDate(yyyymmdd);
        this.calendar = Calendar.getInstance();
        this.calendar.setTime(date);

        this.name = name;

        this.d_today = toDay.getTime();
        this.d_cal = calendar.getTime();

        this.status = Status.UNHANDLED;

    }

    public int getScheduleTime(){
        return this.scheduleTime;
    }


    //練習問題21
    public boolean isExpired() {
        boolean bool = true;
        //calendarの値が今日より"前"である分岐
        if(this.calendar.after(toDay)){
            bool = false;
        }

        return bool;
    }

    //練習問題22
    public boolean onDeadLine(){
        boolean bool = true;

        if(DateUtil.getDaysBetweenDates(this.d_today,this.d_cal)!=0){
            bool = false;
        }

        return bool;
    }

    //練習問題23
    public int restDays(){

        int ans = 0;

        ans = DateUtil.getDaysBetweenDates(this.d_today,this.d_cal);


        return ans;
    }

    //練習問題24　今日から期日までの平日の日数計算
    public int countToDeadLineDate() throws ParseException {

        int ans = 0;

        String s_today = sdf.format(d_today);
        String s_cal = sdf.format(d_cal);


        ans = DateUtil.countWorkingDays(s_today,s_cal);

        return ans;
    }

    //練習問題25

    public static int sumArrays(int[] array){

        int sum = 0;

        for (int i = 0;i < array.length;i++){
            sum = sum + array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println(sum);

        return sum;
    }


    //ToDo 各タスクで所要時間の合計時間を返す
    public static int getSumActualTimes(int[] actualTimes){

        int sumTimes = sumArrays(actualTimes);

        return sumTimes;
    }



    public static int getSumScheduleTimesInStream(Task[] tasks){

        List<Task> list_task = new ArrayList<>();
        list_task = Arrays.asList(tasks);


        int sumTimes = list_task.stream()
                        .mapToInt(i -> i.getScheduleTime())
                        .sum();
        return sumTimes;
    }


}
