import calculator.{CalculationRequest, CalculationResult}
import calculator.CalculatorGrpc.Calculator

import scala.concurrent.Future

object CalculatorService extends Calculator {
  def calculate(request: CalculationRequest): Future[CalculationResult] = {
    import scala.concurrent.ExecutionContext.Implicits.global
    Future {
      CalculationResult(
        Calculator.evaluatePostfix(request.expression)
      )
    }
  }
}
