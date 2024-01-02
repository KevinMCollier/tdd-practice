package com.kevin.tdd;

interface Expression {
  Money reduce(Bank bank, String to);
}

class Sum implements Expression {
  Money augend;
  Money addend;

  Sum(Money augend, Money addend) {
    this.augend = augend;
    this.addend = addend;
  }

  public Money reduce(Bank bank, String to) {
    int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
    return new Money(amount, to);
  }
}

class Bank {
  Money reduce(Expression source, String to) {
    return source.reduce(this, to);
  }
}

class Money implements Expression {
  protected int amount;
  protected String currency;

  Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  Money times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  public Expression plus(Money addend) {
    return new Sum(this, addend);
  }

  public Money reduce(Bank bank, String to) {
    return this;
  }

  public boolean equals(Object object) {
    Money money = (Money) object;
    return amount == money.amount
      && currency().equals(money.currency());
  }

  public String currency() {
    return this.currency;
  }

  public String toString() {
    return amount + " " + currency;
  }
}
