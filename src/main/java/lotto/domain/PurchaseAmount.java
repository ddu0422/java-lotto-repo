package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;

    private final int price;

    private PurchaseAmount(int price) {
        checkMinimumAmount(price);
        checkChange(price);
        this.price = price;
    }

    private void checkMinimumAmount(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 금액보다 적은 금액입니다.");
        }
    }

    private void checkChange(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("거스름돈이 존재합니다.");
        }
    }

    public static PurchaseAmount of(int price) {
        return new PurchaseAmount(price);
    }

     public int purchaseTotalQuantity() {
        return price / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount purchaseAmount = (PurchaseAmount) o;
        return price == purchaseAmount.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
