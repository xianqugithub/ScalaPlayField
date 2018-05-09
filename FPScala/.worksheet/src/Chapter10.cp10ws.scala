package Chapter10

import Monoid._

object cp10ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(373); 
  
 // Exercise 10.11
 def wordCount(s: String) = {
 	def wc(c: Char): WC =
 		if (c == ' ') Part("", 0 ,"")
    else Stub(c.toString)
    
  def getLen(s: String) = s.length min 1
  
  foldMapV(s.toIndexedSeq, wcMonoid)(wc) match {
  		case Stub(s) => getLen(s)
    case Part(l, w, r) => getLen(l) + w + getLen(r)
  }
 };System.out.println("""wordCount: (s: String)Int""");$skip(34); val res$0 = 
 
 wordCount("mimi loves youyou");System.out.println("""res0: Int = """ + $show(res$0));$skip(197); 
 //Exercise 10.16
 def productMonoid[A,B](A: Monoid[A], B: Monoid[B]) = new Monoid[(A, B)] {
 		def op(x: (A, B), y: (A,B)) = (A.op(x._1, y._1), B.op(x._2, y._2))
 		def zero = (A.zero, B.zero)
 };System.out.println("""productMonoid: [A, B](A: Chapter10.Monoid[A], B: Chapter10.Monoid[B])Chapter10.Monoid[(A, B)]""");$skip(193); 
 
 //Exercise 10.17
 def functionMonoid[A,B](B: Monoid[B]): Monoid[A => B] = new Monoid[A => B] {
 	  def op(f: A => B, g: A => B) = a => B.op(f(a), g(a))
 	  val zero: A => B = a => B.zero
 };System.out.println("""functionMonoid: [A, B](B: Chapter10.Monoid[B])Chapter10.Monoid[A => B]""")}
 
 
 
 
  
  
  
}
