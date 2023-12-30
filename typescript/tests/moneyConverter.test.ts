import { Dollar } from "../src/Money";
import { Franc } from "../src/Money";

describe("Dollar Multiplication", () => {
  it("should multply amount correctly", () => {
    let five: Dollar = new Dollar(5);
    expect(five.times(2)).toEqual(new Dollar(10));
    expect(five.times(3)).toEqual(new Dollar(15));
  });
});

describe("Test equality", () => {
  test("should correctly evaluate equality", () => {
    expect(new Dollar(5).equals(new Dollar(5))).toBeTruthy();
    expect(new Dollar(5).equals(new Dollar(6))).toBeFalsy();
    expect(new Franc(5).equals(new Franc(5))).toBeTruthy();
    expect(new Franc(5).equals(new Franc(6))).toBeFalsy();
  });
});

describe("Franc Multiplication", () => {
  it("should multply amount correctly", () => {
    let five: Franc = new Franc(5);
    expect(five.times(2)).toEqual(new Franc(10));
    expect(five.times(3)).toEqual(new Franc(15));
  });
});
