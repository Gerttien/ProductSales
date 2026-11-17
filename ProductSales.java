public class ProductSales implements IProductSales {

    private int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
    };
    private int salesLimit = 500;

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                if (productSales[i][j] > salesLimit) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                if (productSales[i][j] < salesLimit) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            count += productSales[i].length;
        }
        return (double) total / count;
    }
}