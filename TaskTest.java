    import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
     void isExpired() throws ParseException {
        Task task1 = new Task("task1","2023/10/25");
        assertFalse(task1.isExpired());

        Task task2 = new Task("task2","2023/06/27");
        assertFalse(task2.isExpired());

        Task task3 = new Task("task3","2023/05/31");
        assertTrue(task3.isExpired());

        Task task4 = new Task("task4","2023/04/22");
        assertTrue(task4.isExpired());


    }

    @Test
    void onDeadLine() throws ParseException {
        Task task1 = new Task("task1","2023/05/31");
        assertFalse(task1.onDeadLine());

        Task task2 = new Task("task2","2023/06/05");
        assertTrue(task2.onDeadLine());

        Task task3 = new Task("task3","2023/10/25");
        assertFalse(task3.onDeadLine());

        Task task4 = new Task("task4","2023/12/25");
        assertFalse(task4.onDeadLine());


    }

    @Test
    void restDays() throws ParseException {
        Task task1 = new Task("task1","2023/06/05");
        assertEquals(0,task1.restDays());

        Task task2 = new Task("task2","2023/06/20");
        assertEquals(15,task2.restDays());

        Task task3 = new Task("task3","2023/07/20");
        assertEquals(45,task3.restDays());



    }

    @Test
    void countToDeadLineDate() throws ParseException{
        Task task1 = new Task("task1","2023/06/05");
        assertEquals(1,task1.countToDeadLineDate());

        Task task2 = new Task("task2","2023/06/20");
        assertEquals(12,task2.countToDeadLineDate());

        Task task3 = new Task("task3","2023/07/20");
        assertEquals(34,task3.countToDeadLineDate());

    }

    @Test
    void sumArrays() {
        int[] arr1 = {0,1,2,3,4,5};
        assertEquals(15,Task.sumArrays(arr1));
        int[] arr2 = {0,0,0,0};
        assertEquals(0,Task.sumArrays(arr2));
        int[] arr3 = {10,20,30,40,50};
        assertEquals(150,Task.sumArrays(arr3));
        int[] arr4 = {36,64,27,73};
        assertEquals(200,Task.sumArrays(arr4));




    }

    @Test
    void getSumActualTimes() throws ParseException {
        Task task1 = new Task("task1","2023/06/07");
        task1.actualMinuteTime = 10;

        Task task2 = new Task("task2","2023/06/07");
        task2.actualMinuteTime = 20;

        Task task3 = new Task("task3","2023/06/07");
        task3.actualMinuteTime = 30;

        int[] actualTimes1 = {task1.actualMinuteTime, task2.actualMinuteTime,task3.actualMinuteTime};

        assertEquals(60,Task.getSumActualTimes(actualTimes1));



        Task task4 = new Task("task4","2023/06/07");
        task4.actualMinuteTime = 1000;

        Task task5 = new Task("task5","2023/06/07");
        task5.actualMinuteTime = 200;

        Task task6 = new Task("task6","2023/06/07");
        task6.actualMinuteTime = 30;

        int[] actualTimes = {task4.actualMinuteTime, task5.actualMinuteTime,task6.actualMinuteTime};

        assertEquals(1230,Task.getSumActualTimes(actualTimes));



    }

    @Test
    void getSumScheduleTimesInStream() throws ParseException {
        Task task1 = new Task("task1","2023/06/07");
        task1.scheduleTime = 10;

        Task task2 = new Task("task2","2023/06/07");
        task2.scheduleTime = 20;

        Task task3 = new Task("task3","2023/06/07");
        task3.scheduleTime = 30;

        Task[] tasks = {task1,task2,task3};

        assertEquals(60,Task.getSumScheduleTimesInStream(tasks));



    }
}