import org.scalatest.{WordSpec, Matchers}

class CalculatorSpec extends WordSpec with Matchers {

  import Calculator._

  "postfix calculator" should {

    "handle empty sequence" in {
      evaluatePostfix(Seq.empty) should be(0.0.toString)
    }

    "interpret single operand" in {
      evaluatePostfix(Seq("1")) should be(1.0.toString)
    }

    "evaluate sum" in {
      evaluatePostfix(Seq("1", "2", "+")) should be(3.0.toString)
    }

    "evaluate subtraction" in {
      evaluatePostfix(Seq("7", "3", "-")) should be(4.0.toString)
    }

    "evaluate multiplication" in {
      evaluatePostfix(Seq("2", "2", "*")) should be(4.0.toString)
    }

    "evaluate division" in {
      evaluatePostfix(Seq("0.6", "2", "/")) should be (0.3.toString)
    }

    "evaluate exponentiation" in {
      evaluatePostfix(Seq("2", "3", "^")) should be (8.0.toString)
    }

    "evaluate composed expression" in {
      evaluatePostfix(Seq("5", "1", "2", "+", "4", "*", "+", "3", "-")) should be(14.0.toString)
    }

    "return NaN for malformed expressions" in {
      evaluatePostfix(Seq("+")) should be(nan)
      evaluatePostfix(Seq("1", "2")) should be(nan)
      evaluatePostfix(Seq("1", "+")) should be (nan)
      evaluatePostfix(Seq("1", "2", "+", "+")) should be (nan)
    }

  }

}
