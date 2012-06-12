package euler
import scala.collection.Map
import scala.collection.mutable.HashMap
import com.sun.org.apache.xml.internal.serializer.ToStream

object Problem014 {

  def main(args: Array[String]): Unit = {
    val t1 = System.currentTimeMillis()
    //println(getLongestSequence(1000000))
    //println(getLengthSequence(837799))
    println(euler14(1000000))
    val t2 = System.currentTimeMillis()
    println((t2 - t1) + " ms")
  }
  
  val done = new HashMap[Long, Boolean]
  def getLongestSequence(ceiling: Int): Long = {
    var longestChain = 0L
    var longestStartingNumber = 0
    (ceiling to 1 by -1)
      .foreach{i => 
        if (done.get(i).getOrElse(false)) {
          longestChain
        } else {
          val length = getLengthSequence(i)
          if (length >= longestChain) {
            longestStartingNumber = i
            longestChain = length
          }
        }
    }
    longestStartingNumber
  }

  
  def getLengthSequence(startingPoint: Long): Long = {
    def getLengthSequence(acc: Long, startingPoint: Long): Long = {
	    done(startingPoint) = true
	    if (startingPoint <= 1) {
		  acc + 1
		} else if (startingPoint % 2 == 0) {
		  getLengthSequence(acc + 1, startingPoint / 2)
		} else {
		  getLengthSequence(acc + 1, 3 * startingPoint + 1)
		}
    }
    getLengthSequence(0, startingPoint)
  }

  
  /**
   * Autre solution, à tester
   */
  def euler14fun(n:Long) = {
    def aux(m:Long,acc:Long):Long = m match{
       case 1L => acc
       case k if (k % 2 == 0) => aux(m/2, acc + 1)
       case k => aux(3*k + 1, acc + 1)
    }
    aux(n,1)
  }

  def euler14(N:Long) = {
    def aux(current:Long,max:Long,result:Long):(Long,Long) = current match{
      case 1L => (max,result)
      case 2L => (2L,2L)
      case k if (k % 2 == 0) => aux(current - 1, max, result)
      case k => {
        val res = euler14fun(k)
        if (res > max) aux(current - 2, res, k)
        else aux(current - 2, max, result)
      }
    }
    aux(N,1L,N)
  }
}