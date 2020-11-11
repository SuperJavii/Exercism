package PhoneBill

import org.scalatest.{Matchers, FunSuite}

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
    // should be a free bill as the only phone called is the maximum, so it is free
    PhoneBill.calculation("00:01:07,400-234-090") should be (0)
  }

  test("bill with only one call to pay which is less 5 minutes long") {
    // should cost the amount of seconds multiplied by 3
    PhoneBill.calculation("99:01:07,400-234-090\n00:04:40,100-100-100") should be (840)
  }

  test("bill with only one call to pay which is 5 minutes long") {
    // should cost 5 minutes multiplied by 150
    PhoneBill.calculation("99:01:07,400-234-090\n00:05:00,100-100-100") should be (750)
  }

  test("bill with only one call to pay which is 5 more than minutes long") {
    // should cost the amount of started minutes (6) multiplied by 3
    PhoneBill.calculation("99:01:07,400-234-090\n00:05:01,100-100-100") should be (900)
  }
}
