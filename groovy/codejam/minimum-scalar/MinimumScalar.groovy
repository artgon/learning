def it = new File(args[0]).readLines().iterator()

def testCases = it.next().toInteger()

for ( i in 1..testCases )
{
    def vectorSize = it.next().toInteger()

    def vector1 = []
    def vector2 = []

    // split and then convert each value to a long
    it.next().split(' ').toList().collect( vector1, { x -> x.toLong() } )
    it.next().split(' ').toList().collect( vector2, { x -> x.toLong() } )

    def sum = 0
    for ( j in 1..vectorSize )
    {
       def min = vector1.min()
       def max = vector2.max()

       sum += min * max

       vector1.remove(min)
       vector2.remove(max)
    }
    printf("Case #%d: %d\n", i, sum)
}


