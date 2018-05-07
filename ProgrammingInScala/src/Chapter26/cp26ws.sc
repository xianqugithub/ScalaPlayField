package Chapter26

object cp26ws {
  Email("XianQu", "neu.edu")                      //> res0: String = XianQu@neu.edu
  Email.unapply("xq28@@cornell.edu")              //> res1: Option[(String, String)] = None
  Email.unapply("xq28@gmail.com")                 //> res2: Option[(String, String)] = Some((xq28,gmail.com))
  
  val x:Any = "quxian@g"                          //> x  : Any = quxian@g
  x match {
  case Email(user, domain) => { println("email address")
                                println(x) }
  case _ => {println("not email address")
             println(x) }
  }                                               //> email address
                                                  //| quxian@g
  
  val s = "xianqu@cornell.bio.edu"                //> s  : String = xianqu@cornell.bio.edu
  val ExpandedEmail(name, topdom, subdoms @ _*) = s
                                                  //> name  : String = xianqu
                                                  //| topdom  : String = edu
                                                  //| subdoms  : Seq[String] = WrappedArray(bio, cornell)
 
val assertionsEnabled = true                      //> assertionsEnabled  : Boolean = true

def myAssert(predicate: () => Boolean) =
	if (assertionsEnabled && !predicate())
	throw new AssertionError                  //> myAssert: (predicate: () => Boolean)Unit

myAssert(() => 1 > 2)                             //> java.lang.AssertionError
                                                  //| 	at Chapter26.cp26ws$.myAssert$1(Chapter26.cp26ws.scala:23)
                                                  //| 	at Chapter26.cp26ws$.$anonfun$main$1(Chapter26.cp26ws.scala:25)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at Chapter26.cp26ws$.main(Chapter26.cp26ws.scala:3)
                                                  //| 	at Chapter26.cp26ws.main(Chapter26.cp26ws.scala)


  
}