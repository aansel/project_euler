package euler
import java.util.Calendar

object Problem019 {
  
  def main(args: Array[String]) {
    var sundays = 0
    val cal = Calendar.getInstance()
    cal.setLenient(false)
    cal.set(Calendar.DATE, 1)
	(1901 to 2000).foreach { year =>
	  cal.set(Calendar.YEAR, year)
	  (Calendar.JANUARY to Calendar.DECEMBER).foreach { month =>
	  	cal.set(Calendar.MONTH, month)	  	
	  	if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	  	  sundays += 1
	  	}
	  }
	}
	println(sundays)
  }

}