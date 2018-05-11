package Chapter5

import Stream._

sealed trait Stream[+A] {
  
  // Head Option with pattern matching given by the book example
  def headOptionOne: Option[A] = this match {
    case Empty => None
    case Cons(h, t) => Some(h())
  }
  
  //Exercise 5.6 ???
  def headsOption: Option[A] =
    foldRight(None: Option[A])((h, _) => Some(h))
  
  // Exercise 5.1
  def toList: List[A] = {
    @annotation.tailrec
    def go(s: Stream[A], acc: List[A]): List[A] = s match {
      case Cons(h,t) => go(t(), h() :: acc)
      case _ => acc
    }
    go(this, List()).reverse
  }
  
  // Exercise 5.2
  def take(n: Int): Stream[A] = this match {
    case Cons(h, t) if (n > 1) => cons(h(), t().take(n-1))
    case Cons(h, _) if n == 1 => cons(h(), empty)
    case _ => empty
  }
  
  // Exercise 5.13
  def takeViaUnfold(n: Int): Stream[A] =
    unfold(this, n) {
    case (Cons(h, t), n) if (n > 1) => Some(h(), (t(), n-1))
    case (Cons(h, _), 1) => Some(h(), (empty, 0))
    case _ => None
  }
 
  def drop(n: Int): Stream[A] = this match {
    case Cons(h, t) if (n > 0) => t().drop(n-1)
    case _ => this
  }
  
  // Exercise 5.3 takeWhile with pattern matching 
  def takeWhileOne(p: A => Boolean): Stream[A] = this match {
    case Empty => empty
    case Cons(h, t) => if (p(h())) Stream.cons(h(), t().takeWhileOne(p)) else empty
  }
  
  //Exercise 5.13
  def takeWhileViaUnfold(p: A => Boolean): Stream[A] = 
    unfold(this) {
    case Cons(h, t) if p(h()) => Some(h(), t())
    case _ => None
  }
  
  
  def foldRight[B](z: => B)(f: (A, => B) => B): B = 
    this match {
    case Cons(h, t) => f(h(), t().foldRight(z)(f))
    case _ => z
  }
  
  def exists(p: A => Boolean): Boolean =
    foldRight(false)((a, b) => p(a) || b)
  
  //Exercise 5.4 
  def forAll(p: A => Boolean): Boolean =
    foldRight(true)((a, b) => p(a) && b)
    
  //Exercise 5.5
  def takeWhile(p: A => Boolean): Stream[A] =
    foldRight(empty[A])((a, b) => if (p(a)) Stream.cons(a, b) else empty)
    
  //Exercise 5.7
  def map[B](f: A => B): Stream[B] =
    foldRight(empty[B])((a, b) => Stream.cons(f(a), b))
  
  //Exercise 5.13
  def mapViaUnfold[B](f: A => B): Stream[B] = 
    unfold(this) {
    case Cons(h, t) => Some(f(h()), t())
    case _ => None
  }
  
  
  def filter(p: A => Boolean): Stream[A] =
    foldRight(empty[A])((a, b) => if (p(a)) Stream.cons(a, b) else b)
  
  def append[B >: A](s: Stream[B]): Stream[B] = 
    foldRight(s)((a, b) => Stream.cons(a,b))
  
   def flatMap[B](f: A => Stream[B]): Stream[B] =
    foldRight(empty[B])((a, b) => f(a) append b)
    
   // Exercise 5.13
   def zipAll[B](s2: Stream[B]): Stream[(Option[A], Option[B])] = unfold(this, s2) {
    case (Cons(h1, t1), Cons(h2, t2)) => Some((Some(h1()), Some(h2())), (t1(), t2()))
    case (Cons(h, t), Empty) => Some((Some(h()), None), (t(), Empty)) 
    case (Empty, Cons(h, t)) => Some((None, Some(h())), (Empty, t()))
    case _ => None
  }
  
  // Exercise 5.15
  def tails: Stream[Stream[A]] = unfold(this) {
    case Empty => None
    case s => Some(s, s drop 1)
  } append Stream(empty)
     
    
    
        
}


case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
  }
  
  // Converting the Empty type to desired 
  def empty[A]: Stream[A] = Empty
  
  def apply[A](as: A*): Stream[A] = 
    if (as.isEmpty) empty else cons(as.head, apply(as.tail:_*))
    
  // Exercise 5.8
  def constant[A](a: A): Stream[A] = 
  		cons(a, constant(a))
  		
  	// Exercise 5.9
  	def from(n: Int): Stream[Int] =
  	  cons(n, from(n+1))
  
  	// Exercise 5.10
  	def fibs: Stream[Int] = {
  	  def go(f0: Int, f1:Int): Stream[Int] =
  	    cons(f0, go(f1, f0+f1))
    go(0,1)
  }
  
  //Exercise 5.11
  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
    case Some((a,s)) => cons(a, unfold(s)(f)) 
    case None => empty
  }
  
  //Exercise 5.12
  def fibsViaUnfold: Stream[Int] = unfold((0, 1))(s => Some(s._1, (s._2, (s._1 + s._2))))
  
  def fromViaUnfold(n: Int): Stream[Int] = unfold(n)(s => Some(s, s+1))
  
  def constantViaUnfold[A](a: A): Stream[A] = unfold(a)(s => Some(s, s))
  
}