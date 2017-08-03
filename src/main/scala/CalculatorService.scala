import calculator.{CalculationRequest, CalculationResult}

import scala.concurrent.Future

object CalculatorService extends calculator.CalculatorGrpc.Calculator {
  def calculate(request: CalculationRequest): Future[CalculationResult] = {
    import scala.concurrent.ExecutionContext.Implicits.global
    Future {
      CalculationResult(
        Calculator.evaluatePostfix(request.expression)
      )
    }
  }
}
