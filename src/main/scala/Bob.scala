
object Bob {

  val a = ".*[a-zA-Z]+.*"
  val b = ".*\\w.*"

  def response(statement: String): String = {

    val s = statement.trim
    if(isQuestion(s) && (!isShouting(s) || !hasLetters(s))){
      "Sure."

    }else if (!isQuestion(s) && isShouting(s) && hasLetters(s)){
      "Whoa, chill out!"

    }else if(isQuestion(s) && isShouting(s) && hasSound(s)){
      "Calm down, I know what I'm doing!"

    }else if (s.isEmpty){
      "Fine. Be that way!"

    }else{
      "Whatever."
    }
  }

  def isQuestion (statement:String):Boolean ={
    statement.takeRight(1).equals("?")
  }

  def isShouting (statement:String):Boolean={
    statement.equals(statement.toUpperCase)
  }

  def hasLetters(statement: String): Boolean={
    statement.matches(a)
  }

  def hasSound(statement:String):Boolean={
    statement.matches(b)
  }


}
