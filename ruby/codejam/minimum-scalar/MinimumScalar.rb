def removeObjectFromArray( array, object )
  array.slice!(array.index(object))
end

File.open(ARGV[0], 'r') do |file|
  testCases = file.readline 

  for j in 1..testCases.to_i
    vectorSize = file.readline 

    vector1 = file.readline.split(' ')
    vector2 = file.readline.split(' ')

    sum = 0
    while vector1.length > 0
      # make sure to get the min/max of the int value not the string
      min = vector1.each.min_by{|x| x.to_i}
      max = vector2.each.max_by{|x| x.to_i}

      sum += min.to_i * max.to_i

      removeObjectFromArray(vector1, min)
      removeObjectFromArray(vector2, max)
    end

    puts "Case ##{j}: #{sum}"
  end
end


