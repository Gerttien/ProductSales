import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales();
        assertEquals(2, ps.GetSalesOverLimit());
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales();
        assertEquals(4, ps.GetSalesUnderLimit());
    }
}