import org.junit.Assert;
import org.junit.Test;

public class SimpleTests {

    @Test
    public void testNormalWeight(){
        var actualResult = getIMTResult(180f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }
    @Test
    public void testZeroHeight(){
        var actualResult = getIMTResult(0f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
    @Test
    public void testMaxHeight(){
        var actualResult = getIMTResult(-25f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
    @Test
    public void testMaxWeight(){
        var actualResult = getIMTResult(180f, 1000f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }
    @Test
    public void testIMTWeightDeficit(){
        var actualResult = getIMTResult(40f, 180f);
        Assert.assertEquals("выраженный дефицит массы тела", actualResult);
    }
    @Test
    public void testIMTWeightFlaw(){
        var actualResult = getIMTResult(70f, 200f);
        Assert.assertEquals("недостаточная масса тела", actualResult);
    }
    @Test
    public void testIMTWeightNormal(){
        var actualResult = getIMTResult(70f, 180f);
        Assert.assertEquals("нормальная масса тела", actualResult);
    }
    @Test
    public void testIMTWeightExcess(){
        var actualResult = getIMTResult(70f, 150f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg) {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;

        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }

        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";

        return userResult;

    }

}
