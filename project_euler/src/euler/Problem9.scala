package euler

object Problem9 {

  def main(args: Array[String]): Unit = {
    
    var a = 0
    var b = 1
    var c = 0
    
    def find(max: Int) {
      c = max - a - b
      
      // Bonne combinaison non trouvée
      if (c <= b || Math.pow(c, 2) != Math.pow(a, 2) + Math.pow(b, 2)) {
	      // On incrémente a, et b = a + 1
	      if (c <= b) {
	        a += 1
	        b = a + 1
	      }
	      // On incrémente b
	      else {
	        b += 1
	      }
	      find(max)
      }
    }
    
    find(1000)
    
    println("a = " + a)
    println("b = " + b)
    println("c = " + c)
    println("a * b * c = " + (a * b * c))
  }
  

}