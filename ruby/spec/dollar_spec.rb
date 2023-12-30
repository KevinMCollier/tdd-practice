require_relative '../lib/dollar'

RSpec.describe Dollar do
  it "multiplies amount correctly" do
    five = Dollar.new(5)
    five.times(2)
    expect(five.amount).to eq(10)
  end
end
