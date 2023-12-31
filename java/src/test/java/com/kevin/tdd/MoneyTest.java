package com.kevin.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MoneyTest {
  @Test
  public void testMultiplication() {
    Money fiveUSD = Money.dollar(5);
    assertEquals(Money.dollar(10), fiveUSD.times(2));
    assertEquals(Money.dollar(15), fiveUSD.times(3));
  }

  @Test
  public void testEquality() {
    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    assertFalse(Money.franc(5).equals(Money.dollar(5)));
  }

  @Test
  public void testFrancMultiplication() {
    Money fiveCHF = Money.franc(5);
    assertEquals(Money.franc(10), fiveCHF.times(2));
    assertEquals(Money.franc(15), fiveCHF.times(3));
  }

  @Test
  public void testDifferentClassEquality() {
    assertTrue(new Money(10, "USD").equals(new Money(10, "USD")));
  }
}
