def writer(s, start, end_)
  s[start..end_]
end

def nulls(s, i)
  while i < s.length && s[i] == '0'
    if i + 1 < s.length && s[i+1] == '1'
      return i + 1
    elsif i + 1 < s.length && s[i+1] != '0'
      return 0
    end
    i += 1
  end
  0
end

def find_pattern(s)
  res = []
  i = 0
  while i < s.length
    if s[i] == '1'
      if i + 1 < s.length && s[i+1] == '0'
        last = nulls(s, i + 1)
        if last != 0
          res << writer(s, i, last)
          i = last
        end
      elsif i + 1 < s.length && s[i+1] == '1'
        last = nulls(s, i + 2)
        if last != 0
          res << writer(s, i, last)
          i = last
        end
      end
    end
    i += 1
  end
  res
end

str = "1101gdyY101tf11flb10001"
v = find_pattern(str)
if v.empty?
  puts "Not found"
else
  puts v.join(' ')
end