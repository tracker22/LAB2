fn writer(s: &str, start: usize, end: usize) -> String {
    s[start..=end].to_string()
}

fn nulls(s: &str, mut i: usize) -> usize {
    while i < s.len() && s.chars().nth(i).unwrap() == '0' {
        if i + 1 < s.len() && s.chars().nth(i + 1).unwrap() == '1' {
            return i + 1;
        } else if i + 1 < s.len() && s.chars().nth(i + 1).unwrap() != '0' {
            return 0;
        }
        i += 1;
    }
    0
}

fn find_pattern(s: &str) -> Vec<String> {
    let mut res: Vec<String> = vec![];
    let mut i = 0;
    while i < s.len() {
        if s.chars().nth(i).unwrap() == '1' {
            if i + 1 < s.len() && s.chars().nth(i + 1).unwrap() == '0' {
                let last = nulls(s, i + 1);
                if last != 0 {
                    res.push(s[i..=last].to_string());
                    i = last;
                }
            } else if i + 1 < s.len() && s.chars().nth(i + 1).unwrap() == '1' {
                let last = nulls(s, i + 2);
                if last != 0 {
                    res.push(s[i..=last].to_string());
                    i = last;
                }
            }
        }
        i += 1;
    }
    res
}

fn main() {
    let str = "1101gdyY101tf11flb10001";
    let v = find_pattern(str);
    if v.is_empty() {
        println!("Not found");
    } else {
        for item in v {
            print!("{} ", item);
        }
    }
}