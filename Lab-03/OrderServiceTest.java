import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderServiceParameterizedTest 
{

    private final double total;
    private final double discount;
    private final double expected;

    public OrderServiceParameterizedTest(double total, double discount, double expected) 
  {
        this.total = total;
        this.discount = discount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {100.0, 10.0, 90.0},
                {200.0, 25.0, 150.0},
                {50.0, 5.0, 47.5},
                {100.0, 0.0, 100.0},
                {100.0, 100.0, 0.0}
        });
    }

    @Test
    public void testApplyDiscount() 
  {
        OrderService orderService = new OrderService();
        double result = orderService.applyDiscount(total, discount);
        assertEquals("Discount calculation failed", expected, result, 0.001);
        System.out.println("Ran: applyDiscount(" + total + ", " + discount + ") : " + result);
    }
}
