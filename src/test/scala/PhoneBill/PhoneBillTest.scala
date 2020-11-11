package PhoneBill

class PhoneBillTest extends FunSuite with Matchers {

  test("example bill") {
  // should return 900
    PhoneBill.calculation(
      "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090") should be (900)
  }

  test("bill with two numbers in maximum ") {
    // should take the highest telephone number between two largest overall call numbers for free
    PhoneBill.calculation("00:01:07,400-234-090\n00:05:01,400-234-090\n00:05:01,701-080-080\n00:01:07,701-" +
      "080-080\n00:05:01,701-080-081") should be (2001)

  }

  test("bill with only one call") {
    // should be a free bill as the only phone been called is the maximum, so it is free
    PhoneBill.calculation("00:01:07,400-234-090") should be (0)
  }

}
