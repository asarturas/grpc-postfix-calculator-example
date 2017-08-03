import calculator.{CalculationRequest, CalculationResult}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{FlatSpec, Matchers}

import scala.util.Success

class CalculatorServiceSpec extends FlatSpec with Matchers with ScalaFutures {
  it should "return calculation result" in {
    val calculation = CalculatorService.calculate(new CalculationRequest(Seq("7", "3", "-")))
    ScalaFutures.whenReady(calculation) { result =>
      result should be(CalculationResult("4.0"))
    }
  }
}
