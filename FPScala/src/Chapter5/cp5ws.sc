package Chapter5

import Stream._

object cp5ws {
  
  Stream(1,2,3).tails.toList(0).toList            //> res0: List[Int] = List(1, 2, 3)
  Stream(1,2,3).tails.toList(1).toList            //> res1: List[Int] = List(2, 3)
  
  
   

}