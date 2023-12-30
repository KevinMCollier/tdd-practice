class Money {
  protected amount: number;

  constructor(amount: number){
    this.amount = amount;
  }

  equals(money: Money): Boolean{
    return this.amount === money.amount;
  }
}

class Dollar extends Money {
  constructor(amount: number){
    super(amount)
  }

  times(multiplier: number): Dollar{
    return new Dollar(this.amount * multiplier)
  }
}

class Franc extends Money {
  constructor(amount: number){
    super(amount)
  }

  times(multiplier: number): Franc{
    return new Franc(this.amount * multiplier)
  }
}

export { Dollar, Franc };
