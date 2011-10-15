import sys

with open(sys.argv[1]) as f:
	testCases = f.readline()

	for i in range(0, int(testCases)):
		vectorSize = f.readline()

		vector1 = f.readline().rstrip('\n').split(' ')
		vector2 = f.readline().rstrip('\n').split(' ')

		sumV = 0
		for j in range(0, int(vectorSize)):
			minV = min( long(s) for s in vector1 )
			maxV = max( long(t) for t in vector2 )
      
			sumV += minV * maxV

      			vector1.remove(str(minV))
      			vector2.remove(str(maxV))

    		print 'Case #' + str(i+1) + ': ' + str(sumV)



