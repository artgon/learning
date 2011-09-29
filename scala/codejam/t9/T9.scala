object T9 extends App {
  val dictionaryMap = Map[String, List[Int]](("a", List(2)), ("b", List(2, 2)),
    ("c", List(2, 2, 2)), ("d", List(3)), ("e", List(3, 3)), ("f", List(3, 3, 3)),
    ("g", List(4)), ("h", List(4, 4)), ("i", List(4, 4, 4)), ("j", List(5)), ("k", List(5, 5)),
    ("l", List(5, 5, 5)), ("m", List(6)), ("n", List(6, 6)), ("o", List(6, 6, 6)),
    ("p", List(7)), ("q", List(7, 7)), ("r", List(7, 7, 7)), ("s", List(7, 7, 7, 7)),
    ("t", List(8)), ("u", List(8, 8)), ("v", List(8, 8, 8)), ("w", List(9)), ("x", List(9, 9)),
    ("y", List(9, 9, 9)), ("z", List(9, 9, 9, 9)), (" ", List(0)))

  // input file from args
  val iterator = scala.io.Source.fromFile(args(0)).getLines()

  // grab the number of test cases
  val testCases = iterator.next()

  // iterate test cases
  for (i <- 0 until testCases.toInt) {
    // get the next input
    val input = iterator.next()

    // define the method printing result
    def numberForLetter(c: String, next: String, isLastChar: Boolean) {
      // get the mapping
      val mapping = dictionaryMap(c)

      // print each item from the mapping
      mapping.foreach(print(_))

      // figure out where spaces, linebreaks go
      if (isLastChar) {
        println("")
      }
      // if mapping numbers are the same, user needs to pause
      else if (mapping(0) == dictionaryMap(next)(0)) {
        print(" ")
      }
    }

    // print case number
    print("Case #" + (i + 1) + ": ")
    // iterate letters in the input to print their mapping
    for (i <- 0 until input.size) {
      val letter = input(i).toString

      numberForLetter(letter, {
        // provide next letter for testing whether space is needed
        val nextLetterIndex = i + 1
        if (nextLetterIndex >= input.size) {
          " "
        }
        else {
          input(nextLetterIndex).toString
        }
      }, i >= input.size - 1)
    }
  }
}