import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DateDataTest {
     DateData dd;

    DateDataTest() {
        dd = new DateData();
    }


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void setDateData() {
        dd.setDateData(null);
        assertNull(dd.getDateData());
    }

    @Test
    void getDateData() {
        dd.setDateData("20200916");
        assertEquals("20200916", dd.getDateData());
    }

    @Test
    void getToday() {
        Calendar cal = Calendar.getInstance();
        String toDay = String.format("%02d", cal.get(Calendar.YEAR)) +
                String.format("%02d", cal.get(Calendar.MONTH) + 1) +
                String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(toDay, dd.getToday());
    }
    @Test
    void isToday() {
        Calendar cal = Calendar.getInstance();

        String today = String.format("%02d", cal.get(Calendar.YEAR)) +
                String.format("%02d", cal.get(Calendar.MONTH) + 1) +
                String.format("%02d", cal.get(Calendar.DAY_OF_MONTH));


        assertEquals(true, today.equals(dd.getToday()));
        }


    @Test
    void isLeapYear() {
        assertEquals(true, dd.isLeapYear("20200916"));
        assertEquals(false, dd.isLeapYear("20210916"));
        assertEquals(true, dd.isLeapYear("20000916"));
        assertEquals(true, dd.isLeapYear("2020"));
        assertEquals(false, dd.isLeapYear("2021"));
        assertEquals(true, dd.isLeapYear("2000"));
    }

}