package Chapter5

import Stream._

object cp5ws {
  
  fibs.take(5).toList                             //> res0: List[Int] = List(0, 1, 1, 2, 3)
  
  fibsViaUnfold.take(5).toList                    //> res1: List[Int] = List(0, 1, 1, 2, 3)
  
  from(1).take(9).toList                          //> res2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  fromViaUnfold(1).take(9).toList                 //> res3: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  
  constant("youyou").take(10).toList              //> res4: List[String] = List(youyou, youyou, youyou, youyou, youyou, youyou, yo
                                                  //| uyou, youyou, youyou, youyou)
  constantViaUnfold("youyou").take(10).toList     //> res5: List[String] = List(youyou, youyou, youyou, youyou, youyou, youyou, yo
                                                  //| uyou, youyou, youyou, youyou)
  
  
   

}