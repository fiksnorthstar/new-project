import org.junit.Assert;
import org.junit.Test;

public class MyHomeworkTests {

    @Test
    public void cancelTransfer(){
        var actualResult = getRefundTicketPricePercent( 23, true, true );
        Assert.assertEquals((Integer)100, actualResult);
    }
    @Test
    public void afterConcertOwn(){
        var actualResult = getRefundTicketPricePercent( 23, false, false );
        Assert.assertEquals((Integer) 30, actualResult);
    }
    @Test
    public void afterConcertTwo(){
        var actualResult = getRefundTicketPricePercent( 155, false, false );
        Assert.assertEquals((Integer) 50, actualResult);
    }
    @Test
    public void afterConcertThree(){
        var actualResult = getRefundTicketPricePercent( 260, false, false );
        Assert.assertEquals((Integer) 100, actualResult);
    }
    @Test
    public void minHours(){
        var actualResult = getRefundTicketPricePercent( 2, false, false );
        Assert.assertEquals((Integer) 0, actualResult);
    }

    /*
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:
    1) более 10 дней - получить обратно полную стоимость билетов;
    2) от 6 до 10 дней включительно - получить только 50% стоимости билетов;
    3) от 3 до 6 дней включительно - получить 30% стоимости билетов;
    4) 72 часа и менее до начала концерта - стоимость билетов не возвращается.
     */
    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert > 240) return 100;
        if(hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if(hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;
        return 0;
    }


    /*
    Всего ученик может заработать максимум 100 баллов, минимум 0.
    Его оценка за экзамен может принимать следующие значения: 2, 3, 4 или 5.

    Если ученик получил за экзамен:
    - от 0 баллов (включительно) до 35 (включительно), его оценка равна 2;
    - от 35 баллов (не включительно) до 56 (включительно), его оценка равна 3;
    - от 56 баллов (не включительно) до 71 (включительно), его оценка равна 4;
    - от 72 баллов (включительно) до 100 баллов (включительно), его оценка равна 5.
     */

    @Test
    public void testCentralImportanceTwo(){
        String actualResult = getMarkResult(15);
        Assert.assertEquals("2", actualResult);
    }
    @Test
    public void testCentralImportanceThree(){
        String actualResult = getMarkResult(45);
        Assert.assertEquals("3", actualResult);
    }
    @Test
    public void testCentralImportanceFour(){
        String actualResult = getMarkResult(63);
        Assert.assertEquals("4", actualResult);
    }
    @Test
    public void testCentralImportanceFive(){
        String actualResult = getMarkResult(85);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testBoundaryImportanceTwo(){
        String actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }
    @Test
    public void testBoundaryImportanceThree(){
        String actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }
    @Test
    public void testBoundaryImportanceFour(){
        String actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }
    @Test
    public void testBoundaryImportanceFive(){
        String actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }
    @Test
    public void testBeyondImportanceTwo(){
        String actualResult = getMarkResult(-5);
        Assert.assertEquals("no mark result", actualResult);
    }
    @Test
    public void testBeyondImportanceFive(){
        String actualResult = getMarkResult(115);
        Assert.assertEquals("no mark result", actualResult);
    }

    private String getMarkResult(Integer mark)
    {
        if(mark >= 0 && mark <= 35) return "2";
        if(mark > 35 && mark <= 56) return "3";
        if(mark > 56 && mark < 71) return "4";
        if(mark > 72 && mark < 100) return "5";
        return "no mark result";
    }

}
