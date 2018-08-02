package inc.manpower.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentsUtilsTest {

    @Test
    public void calculateMansonTest() {
        Double calculatedAmount = PaymentsUtils.calculateCommission(200d, 3, 18);
        assertThat(Double.valueOf(3900)).isEqualTo(calculatedAmount);
    }

    @Test
    public void calculateCarpenterTest() {
        Double calculatedAmount = PaymentsUtils.calculateCommission(250d, 3, 18);
        assertThat(Double.valueOf(4875)).isEqualTo(calculatedAmount);
    }

}
