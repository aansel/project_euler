package euler.problem013
import scala.io.Source

object Problem013 {

  def main(args: Array[String]) {
    val t1 = System.currentTimeMillis()
    println(getSum())
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  def getSum(): BigInt = {
    Source.fromInputStream(getClass().getResourceAsStream("file.txt"))
      .getLines()
      .foldLeft(BigInt(0))(_ + BigInt(_))
  }
  
}