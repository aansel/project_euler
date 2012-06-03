package euler

object Problem2 {

  def main(args: Array[String]): Unit = {
    
    println("Result : " + sumEvenFibonacci(4000000));
    
  }
  
  
  def sumEvenFibonacci(limit: Int): Int = {
    var fibnm2 = 1;
    var fibnm1 = 2;
    var fibn = fibnm1 + fibnm2;
    var sum = fibnm1;
    var i = 1;
    while(fibn < limit) {
      
      fibnm2 = fibnm1;
      fibnm1 = fibn;
      fibn = fibnm2 + fibnm1;
     
      if (i == 2) {
    	  sum += fibn;
    	  i = 0;
      } else {
    	  i = i + 1;
      }
    }
    sum;
  }

}