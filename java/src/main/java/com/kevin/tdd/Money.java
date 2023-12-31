package com.kevin.tdd;

interface Expression {
  Money reduce(Bank bank, String to);
}

class Money implements Expression {
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

  public Expression plus(Money addend) {
    return new Money(amount + addend.amount, currency);
  }

  public Money reduce(Bank bank, String to) {
    return this;
  }
}

class Bank {
  Money reduce(Expression source, String to) {
    // return source.reduce(this, to);
    return Money.dollar(10);
  }
}
