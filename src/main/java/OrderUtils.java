import java.util.List;

public class OrderUtils {
    // Calculates total price after applying discount percentage.
    public static double calculateDiscountedTotal(double total, double discountPercent) {
        if (total < 0 || discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Invalid input.");
        }
        return total - (total * discountPercent / 100);
    }

    // Validates if an email format is acceptable.
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    // Calculates average order value.
    public static double calculateAverage(List<Double> orders) {
        if (orders == null || orders.isEmpty()) {
            throw new IllegalArgumentException("Order list cannot be empty.");
        }
        return orders.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    // Returns true if all order values are non-negative.
    public static boolean allOrdersValid(List<Double> orders) {
        if (orders == null) return false;
        return orders.stream().allMatch(o -> o != null && o >= 0);
    }

    // Converts currency from USD to VND.
    public static long convertUsdToVnd(double usd) {
        if (usd < 0) {
            throw new IllegalArgumentException("USD must be non-negative.");
        }
        return (long)(usd * 24000); // Assume fixed rate.
    }
}