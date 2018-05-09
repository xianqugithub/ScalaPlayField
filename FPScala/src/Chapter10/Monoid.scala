package Chapter10

trait Monoid[A] {
   def op(a1: A, a2:A): A
   def zero: A
}

object Monoid {
  // Exercise 10.1
  val intAddition: Monoid[Int] = new Monoid[Int] {
  		def op(a1: Int, a2: Int) = a1 + a2
  		val zero = 0
  }
   
  val intMultiplication = new Monoid[Int] {
  		def op(a1: Int, a2: Int) = a1 * a2
  		val zero = 1
  }
  
  val booleanOr = new Monoid[Boolean] {
  	 	def op(a1: Boolean, a2: Boolean) = a1 || a2
  	 	val zero = false
  }
  
  val booleanAnd = new Monoid[Boolean] {
  		def op(a1: Boolean, a2: Boolean) = a1 && a2
  		val zero = true
  }
  
  // Exercise 10.2
  
  def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
  		def op(a1: Option[A], a2: Option[A]) = a1 orElse a2
  		val zero = None
  }
  
  // Exercise 10.3
  // compose is a key word
  def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
  		def op(a1: A => A, a2: A => A) = a1 compose a2
  		val zero = (a: A) => a
  }
  
  //Exercise 10.5
  //map version
  def foldMap1[A,B](as: List[A], m: Monoid[B])(f: A => B): B =
  		as.map(f).foldLeft(m.zero)(m.op)
  //non-map version
  def foldMap2[A,B](as: List[A], m: Monoid[B])(f: A => B): B =
  	  as.foldRight(m.zero)((a, b) => m.op(f(a), b))
  //Exercise 10.7
  def foldMapV[A,B] (v: IndexedSeq[A], m:Monoid[B])(f: A => B): B =
  		if (v.length == 0)
  			m.zero
  	  else if (v.length == 1)
  	  	  f(v(0))
  		else {
  			val (l, r) = v.splitAt(v.length/2)
  			m.op(foldMapV(l, m)(f), foldMapV(r, m)(f))
  		}
  		
  // Exercise 10.10
 val wcMonoid = new Monoid[WC] {
 	def op(w1: WC, w2: WC) = (w1, w2) match {
 	 case (Stub(s1), Stub(s2)) => Stub(s1+s2)
 	 case (Stub(s1), Part(ls, w, rs)) => Part(s1+ls, w, rs)
 	 case (Part(ls, w, rs), Stub(s2)) => Part(ls, w, rs+s2)
 	 case (Part(ls1, w1, rs1), Part(ls2, w2, rs2)) => Part(ls1, w1+w2+ (if ((rs1+ls2).isEmpty) 0 else 1), rs2)
 	}
 	def zero = Stub("")
 }
  
  
}