package Chapter11

object cp10ws {
	
	def error(message: String): Nothing =
		throw new RuntimeException(message)
                                                  //> error: (message: String)Nothing



  def divide(x: Int, y: Int): Int =
  		if (y != 0) x / y
  		else error("can't divide by zero")//> divide: (x: Int, y: Int)Int
  		
  val a = divide(10,1)                            //> a  : Int = 10
  val b = divide(10,0)                            //> java.lang.RuntimeException: can't divide by zero
                                                  //| 	at Chapter11.cp10ws$.error$1(Chapter11.cp10ws.scala:6)
                                                  //| 	at Chapter11.cp10ws$.divide$1(Chapter11.cp10ws.scala:12)
                                                  //| 	at Chapter11.cp10ws$.$anonfun$main$1(Chapter11.cp10ws.scala:15)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at Chapter11.cp10ws$.main(Chapter11.cp10ws.scala:3)
                                                  //| 	at Chapter11.cp10ws.main(Chapter11.cp10ws.scala)
  
 
}