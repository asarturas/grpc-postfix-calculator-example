import calculator.{CalculationRequest, CalculatorGrpc}
import io.grpc.{ManagedChannelBuilder, ServerBuilder}

import scala.concurrent.ExecutionContext

object CalculatorServer extends App {

  val server = ServerBuilder
    .forPort(55155)
    .addService(CalculatorGrpc.bindService(CalculatorService, ExecutionContext.global))
    .build.start

//  // sample async client
//  import scala.concurrent.ExecutionContext.Implicits.global
//  val client = CalculatorGrpc.stub(
//    ManagedChannelBuilder.forAddress("localhost", 55155).usePlaintext(true).build
//  )
//  client.calculate(CalculationRequest(Seq("5", "1", "2", "+", "4", "*", "+", "3", "-"))).onComplete { result =>
//    println(result)
//  }

  server.awaitTermination()

}