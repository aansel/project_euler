package euler

object Problem015 {

  def main(args: Array[String]) = {
    val t1 = System.currentTimeMillis()
    println(getRoutesNumber(20))
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  def getRoutesNumber(dimension: Int): Long = {
    
    var routes = Array.ofDim[Long](dimension + 1, dimension + 1)
    // Remonter la diagonale
    (0 to dimension).foreach(iDiag =>
      // Remonter verticalement et horizontalement
      (iDiag to dimension).foreach(index =>
        if (iDiag == 0) {
          routes(iDiag)(index) = 1L
          routes(index)(iDiag) = 1L
        } else {
          routes(iDiag)(index) = routes(iDiag - 1)(index) + routes(iDiag)(index - 1)
          routes(index)(iDiag) = routes(index - 1)(iDiag) + routes(index)(iDiag - 1)
        }
      )
    )    
    routes(dimension)(dimension)
  }

}