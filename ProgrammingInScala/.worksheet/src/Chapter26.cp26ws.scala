package Chapter26

object cp26ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(63); val res$0 = 
  Email("XianQu", "neu.edu");System.out.println("""res0: String = """ + $show(res$0));$skip(37); val res$1 = 
  Email.unapply("xq28@@cornell.edu");System.out.println("""res1: Option[(String, String)] = """ + $show(res$1));$skip(34); val res$2 = 
  Email.unapply("xq28@gmail.com");System.out.println("""res2: Option[(String, String)] = """ + $show(res$2));$skip(28); 
  
  val x:Any = "quxian@g";System.out.println("""x  : Any = """ + $show(x ));$skip(186); 
  x match {
  case Email(user, domain) => { println("email address")
                                println(x) }
  case _ => {println("not email address")
             println(x) }
  };$skip(38); 
  
  val s = "xianqu@cornell.bio.edu";System.out.println("""s  : String = """ + $show(s ));$skip(52); 
  val ExpandedEmail(name, topdom, subdoms @ _*) = s;System.out.println("""name  : String = """ + $show(name ));System.out.println("""topdom  : String = """ + $show(topdom ));System.out.println("""subdoms  : Seq[String] = """ + $show(subdoms ));$skip(31); 
 
val assertionsEnabled = true;System.out.println("""assertionsEnabled  : Boolean = """ + $show(assertionsEnabled ));$skip(108); 

def myAssert(predicate: () => Boolean) =
	if (assertionsEnabled && !predicate())
	throw new AssertionError;System.out.println("""myAssert: (predicate: () => Boolean)Unit""");$skip(23); 

myAssert(() => 1 > 2)}


  
}
