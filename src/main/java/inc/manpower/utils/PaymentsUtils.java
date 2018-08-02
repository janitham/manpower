package inc.manpower.utils;

public final class PaymentsUtils {

    public static final Double COMMISSION = 0.5;

    public static final Double calculateCommission(Double amount, long groupsCount, long empCount) {
       return amount * (empCount + groupsCount * COMMISSION);
    }
}
