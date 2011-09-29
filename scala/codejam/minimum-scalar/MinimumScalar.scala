object MinimumScalar extends App {

  // input file from args
  val iterator = scala.io.Source.fromFile(args(0)).getLines()

  // grab the number of test cases
  val testCases = iterator.next()

  // iterate test cases
  for (j <- 0 until testCases.toInt) {
    // grab vector size
    val vectorSize = iterator.next()

    // grab the two vectors to multiply, delimited by spaces and convert to BigInt
    var vector1: List[BigInt] = iterator.next().split(' ').toList.map(BigInt(_))
    var vector2: List[BigInt] = iterator.next().split(' ').toList.map(BigInt(_))

    // iterate vector size
    var sum: BigInt = 0
    for (i <- 0 until vectorSize.toInt) {

      // grab the min from one vector and the max from another
      // (could do it the other way around, doesn't matter)
      val min = vector1.min
      val max = vector2.max

      // this ensures the largest value is always multiplied by the smallest
      // therefore, giving us a minimum product
      sum += min * max

      // remove the values just multiplied for next loop
      vector1 = dropIndex(vector1, vector1.indexOf(min, 0))
      vector2 = dropIndex(vector2, vector2.indexOf(max, 0))
    }

    // method to drop an element at an index from a list
    def dropIndex[T](xs: List[T], n: Int) = {
      val (l1, l2) = xs splitAt n
      l1 ::: (l2 drop 1)
    }

    // print output for this test case
    println("Case #" + (j + 1) + ": " + sum)
  }
}
