import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AddDate {

    public static void main(String[] args) {

        //コマンドライン引数なら
       Scanner scanner = new Scanner(System.in);
       System.out.print("日付を入力してください (yyyy/MM/dd): ");
       String inputDate = scanner.next(); // コマンドラインから日付を読み取ります。
       System.out.print("加算する日数を整数で入力してください: ");
       int daysToAdd = Integer.parseInt(scanner.next()); // コマンドラインから日付を読み取ります。
        // String inputDate = "2023/04/26";
        // int daysToAdd = 5;

        try {
            Date date = validateAndParseDate(inputDate);
            Date newDate = addDaysToDate(date, daysToAdd);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);

        return sdf.parse(inputDate);
    }

    public static Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}