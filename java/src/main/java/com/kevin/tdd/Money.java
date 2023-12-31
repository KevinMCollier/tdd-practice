package com.kevin.tdd;

class Money {
  protected int amount;
  protected String currency;

  Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public String currency() {
    return this.currency;
  }

  public String toString() {
    return amount + " " + currency;
  }

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount
      && currency().equals(money.currency());
  }

  static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }
}
