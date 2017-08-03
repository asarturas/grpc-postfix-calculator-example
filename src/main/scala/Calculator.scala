import scala.util.{Failure, Success, Try}

object Calculator {

  val nan = "NaN"

  def evaluatePostfix(sequence: Seq[String], stack: List[Double] = List.empty): String = {
    if (sequence.isEmpty) {
      if (stack.isEmpty) 0.0.toString
      else if (stack.size == 1) stack.head.toString
      else nan
    }
    else {
      val symbol = sequence.head
      Try(symbol.toDouble) match {
        case Success(operand) => evaluatePostfix(sequence.tail, operand :: stack)
        case Failure(_) => stack match {
          case operand2 :: operand1 :: rest =>
            val maybeResult = calculate(operand1, symbol, operand2)
            if (maybeResult.isEmpty) nan
            else evaluatePostfix(sequence.tail, maybeResult.get :: rest)
          case _ => nan
        }
      }
    }
  }
  private def calculate(operand1: Double, operator: String, operand2: Double): Option[Double] = {
    operator match {
      case "+" => Some(operand1 + operand2)
      case "-" => Some(operand1 - operand2)
      case "*" => Some(operand1 * operand2)
      case "/" => Some(operand1 / operand2)
      case "^" => Some(math.pow(operand1, operand2))
      case _ => None
    }
  }
}
