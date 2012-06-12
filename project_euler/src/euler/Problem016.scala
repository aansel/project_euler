package euler.problem016

object Problem016 {

  def main(args: Array[String]): Unit = {
    val t1 = System.currentTimeMillis()
    println(digitSum(BigInt(2).pow(1000)))
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  
  def digitSum(number: BigInt): BigInt = {
    number.toString.foldLeft(0)((sum, digit) => sum + digit.toString().toInt)
  }

}