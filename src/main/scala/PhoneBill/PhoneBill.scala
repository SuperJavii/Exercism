package PhoneBill

class PhoneBill {

  def calculation (bill: String): Int = {
    val callsList: Array[String] = bill.split("\n")

    val callTimes: Array[String] = callsList.map(_.split(",")(0))
    val phoneNumbers: Array[String] = callsList.map(_.split(",")(1))
    val callTimesSeconds: Array[Int] = callTimes.map( x =>
      x.split(":")(0).toInt * 360 + x.split(":")(1).toInt * 60 + x.split(":")(2).toInt
    )

    val pricesPerCall: Array[Int] = callTimesSeconds.map( x =>
      if (x < 300) {
        x * 3
      }
      else {
        val hours = callTimes(callTimesSeconds.indexOf(x)).split(":")(0)
        val minutes = callTimes(callTimesSeconds.indexOf(x)).split(":")(1)
        val seconds = callTimes(callTimesSeconds.indexOf(x)).split(":")(2)

        if (seconds.toInt == 0) {
          (hours.toInt * 60 + minutes.toInt) * 150
      }
        else {
          (hours.toInt * 60 + minutes.toInt + 1) * 150
        }
      }
    )

    val callMap: Map[String, Array[Int]] = (phoneNumbers zip callTimesSeconds).groupBy(_._1).mapValues(_.map(_._2))
    val longestDuration: Map[String,Array[Int]] = callMap.filter(_._2.sum equals callMap.mapValues(x => x.sum)
      .maxBy(_._2)._2)
    val freeContactNumber: Int = longestDuration.keys.map(_.replace("-","").toInt).max

    val billPrice = (phoneNumbers zip pricesPerCall).groupBy(_._1).mapValues(_.map(_._2).sum)
      .filter(_._1.replace("-","").toInt != freeContactNumber).values.sum

    println(pricesPerCall.mkString.toString)
    println(freeContactNumber)
    println(billPrice)
    billPrice

  }

}
