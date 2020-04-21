import scala.collection.SortedMap

class School  {

  type DB = SortedMap[Int, Seq[String]]

  var database:DB = SortedMap()

  def add(name: String, g: Int) = {

    val newClassList = if (database.contains(g)){
      database(g):+ name

    }else{
      Seq(name)
    }
    database += (g -> newClassList)

  }

  def db: DB = {
    database
  }

  def grade(g: Int): Seq[String] = {

    if (database.contains(g)){
      database(g)

    }else{
      Seq()
    }
  }

  def sorted:DB = {

    database.mapValues(_.sorted)
  }

}

