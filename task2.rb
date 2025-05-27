def find_unique(v)
  v.uniq
end

def format_email(s)
  result = []
  seen_at = false
  seen_star = false
  
  s.each_char do |c|
    if c == '@'
      seen_at = true
    end
    unless seen_at
      if c == '*'
        seen_star = true
        next
      end
      if seen_star
        next
      end
      if c == '.'
        next
      end
    end
    result << c
  end
  result.join
end

def is_allowed(s)
  not_allowed_chars = ['&', '=', '+', '-', '_', '<', '>', ',', "'"]
  return false if s.nil? || s.empty? || s[0] == '.'
  return false unless s.include?('@')
  
  at_index = s.index('@')
  return false if at_index < 6 || at_index > 30
  
  s[0...at_index].each_char do |c|
    return false if not_allowed_chars.include?(c)
  end
  
  last_dot = s.rindex('.')
  return false if last_dot.nil? || last_dot <= at_index
  true
end

v = [".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru"]
filtered = v.select { |email| is_allowed(email) }.map { |email| format_email(email) }
if filtered.empty?
  puts "No unique emails"
else
  puts find_unique(filtered).size
end
