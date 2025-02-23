import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1); // Add a dummy product to help with calculations
    }
    
    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
            products.add(1); // Reset the products list and add the dummy product
        } else {
            int lastProduct = products.get(products.size() - 1);
            products.add(lastProduct * num);
        }
    }
    
    public int getProduct(int k) {
        int n = products.size();
        if (k >= n) {
            return 0; // The product contains a zero, as we reset the products list upon encountering zero
        }
        return products.get(n - 1) / products.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */






