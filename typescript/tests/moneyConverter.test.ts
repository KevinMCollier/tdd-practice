import { Dollar } from "../src/Dollar";

describe("Dollar Multiplication", () => {
  it("should multply amount correctly", () => {
    let five: Dollar = new Dollar(5);
    five.times(2);
    expect(five.amount).toBe(10);
  });
});
