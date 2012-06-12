package euler

object Problem017 {

  def main(args: Array[String]): Unit = {
    
    val t1 = System.currentTimeMillis();
    problem17()
    val t2 = System.currentTimeMillis();
    println((t2 - t1) + " ms")
  }
  
  def problem17() {
    var length = 0
    (1 to 1000).foreach(length += numberToString(_).length())
    println(length)
  }
  
  def numberToString(number: Int): String = {
    number match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case 4 => "four"
      case 5 => "five"
      case 6 => "six"
      case 7 => "seven"
      case 8 => "eight"
      case 9 => "nine"
      case 10 => "ten"
      case 11 => "eleven"
      case 12 => "twelve"
      case 13 => "thirteen"
      case 14 => "fourteen"
      case 15 => "fifteen"
      case 16 => "sixteen"
      case 17 => "seventeen"
      case 18 => "eighteen"
      case 19 => "nineteen"
      case 20 => "twenty"  
      case 30 => "thirty"
      case 40 => "forty"
      case 50 => "fifty"
      case 60 => "sixty"
      case 70 => "seventy"
      case 80 => "eighty"
      case 90 => "ninety"
      case 1000 => "onethousand"
      case i if (i < 100) => numberToString(10 * (i / 10)) + numberToString(i % 10)
      case i if (i % 100 == 0) => numberToString(i / 100) + "hundred"
      case i => numberToString(100 * (i / 100)) + "and" + numberToString(i % 100)
    }
    
  }

}

