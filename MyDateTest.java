import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class MyDateTest {

    @Test
    void isWeekday() throws ParseException {
        assertEquals(false,MyDate.isWeekday("2023/05/14"));
        assertEquals(true,MyDate.isWeekday("2023/05/15"));
        assertEquals(true,MyDate.isWeekday("2023/05/16"));
        assertEquals(true,MyDate.isWeekday("2023/05/17"));
        assertEquals(true,MyDate.isWeekday("2023/05/18"));
        assertEquals(true,MyDate.isWeekday("2023/05/19"));
        assertEquals(false,MyDate.isWeekday("2023/05/20"));
        assertEquals(false,MyDate.isWeekday("2023/05/21"));
        assertEquals(true,MyDate.isWeekday("2023/05/22"));
        assertEquals(true,MyDate.isWeekday("2023/05/23"));
        assertEquals(true,MyDate.isWeekday("2023/05/24"));
    }

    @Test
    void isSundayOrSaturday() throws ParseException {
        assertEquals(true,MyDate.isSundayOrSaturday("2023/05/14"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/15"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/16"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/17"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/18"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/19"));
        assertEquals(true,MyDate.isSundayOrSaturday("2023/05/20"));
        assertEquals(true,MyDate.isSundayOrSaturday("2023/05/21"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/22"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/23"));
        assertEquals(false,MyDate.isSundayOrSaturday("2023/05/24"));

    }
/*
    @Test
    void getNationalHoliday() throws Exception {
        String[] expected = {
                "2023/01/01",
                "2023/01/02",
                "2023/01/09",
                "2023/02/11",
                "2023/02/23",
                "2023/03/21",
                "2023/04/29",
                "2023/05/03",
                "2023/05/04",
                "2023/05/05",
                "2023/07/17",
                "2023/08/11",
                "2023/09/18",
                "2023/09/23",
                "2023/10/09",
                "2023/11/03",
                "2023/11/23"
        };
        assertEquals(expected,MyDate.getNationalHoliday(2023));
    }
*/
    @Test
    void countWorkingDays() throws URISyntaxException, IOException, ParseException {
        assertEquals(3,MyDate.countWorkingDays("2023/05/07","2023/05/10"));
        assertEquals(7,MyDate.countWorkingDays("2023/05/07","2023/05/16"));
        assertEquals(7,MyDate.countWorkingDays("2023/05/20","2023/05/30"));
        assertEquals(0,MyDate.countWorkingDays("2023/05/06","2023/05/07"));
        assertEquals(0,MyDate.countWorkingDays("2023/05/20","2023/05/21"));
        assertEquals(5,MyDate.countWorkingDays("2023/08/14","2023/08/18"));
        assertEquals(22,MyDate.countWorkingDays("2023/01/01","2023/01/31"));

    }

    @Test
    void getNextWeekday() throws ParseException {
        assertEquals("2023/05/25",MyDate.getNextWeekday("2023/05/24"));
        assertEquals("2023/05/08",MyDate.getNextWeekday("2023/05/05"));
        assertEquals("2023/05/08",MyDate.getNextWeekday("2023/05/06"));
        assertEquals("2023/05/15",MyDate.getNextWeekday("2023/05/14"));
        assertEquals("2023/05/15",MyDate.getNextWeekday("2023/05/13"));
        assertEquals("2023/05/29",MyDate.getNextWeekday("2023/05/26"));
        assertEquals("2023/05/31",MyDate.getNextWeekday("2023/05/30"));
    }
}