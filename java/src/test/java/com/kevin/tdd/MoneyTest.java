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

  @Test
  public void testSimpleAddition() {
    Money five = Money.dollar(5);
    Expression sum = five.plus(five);
    Bank bank = new Bank();
    Money reduced = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(10), reduced);
  }

  @Test
  public void testPlusReturnsSum() {
    Money five = Money.dollar(5);
    Expression result = five.plus(five);
    Sum sum = (Sum) result;
    assertEquals(five, sum.augend);
    assertEquals(five, sum.addend);
  }

  @Test
  public void testReduceSum() {
    Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
    Bank bank = new Bank();
    Money result = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(7), result);
  }
}
