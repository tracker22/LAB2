def diff(a, b)
  a > b ? a - b : b - a
end

def prod(n)
  res = 1
  while n > 0
    res *= n % 10
    n /= 10
  end
  res
end

def sum_digits(n)
  res = 0
  while n > 0
    res += n % 10
    n /= 10
  end
  res
end

print "Enter the number: "
num = gets.chomp.to_i
if num > 0
  summary = sum_digits(num)
  product = prod(num)
  puts "#{summary} #{product} #{diff(summary, product)}"
else
  puts "Number is not natural"
end