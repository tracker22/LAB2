use std::collections::HashSet;

fn find_unique(v: &Vec<String>) -> Vec<String> {
    let mut unique = HashSet::new();
    v.iter().filter(|&s| unique.insert(s.clone())).cloned().collect()
}

fn format_email(s: &str) -> String {
    let mut result = String::new();
    let mut seen_at = false;
    let mut seen_star = false;
    
    for c in s.chars() {
        if c == '@' { seen_at = true; }
        if !seen_at {
            if c == '*' { seen_star = true; continue; }
            if seen_star { continue; }
            if c == '.' { continue; }
        }
        result.push(c);
    }
    result
}

fn is_allowed(s: &str) -> bool {
    let not_allowed_chars = ['&', '=', '+', '-', '_', '<', '>', ',', '\''];
    if s.is_empty() || s.starts_with('.') { return false; }
    if !s.contains('@') { return false; }
    
    let at_index = s.find('@').unwrap();
    if at_index < 6 || at_index > 30 { return false; }
    
    for c in s[..at_index].chars() {
        if not_allowed_chars.contains(&c) { return false; }
    }
    
    if s.rfind('.').map_or(true, |i| i <= at_index) { return false; }
    true
}

fn main() {
    let v = vec![
        ".555555@.".to_string(),
        "1111.111@mail.ru".to_string(),
        "11111111@.mailru".to_string(),
        "1111111@.mailru".to_string(),
        "11111111@.mailru".to_string()
    ];
    
    let filtered: Vec<String> = v.into_iter()
        .filter(|s| is_allowed(s))
        .map(|s| format_email(&s))
        .collect();
    
    if filtered.is_empty() {
        println!("No unique emails");
    } else {
        println!("{}", find_unique(&filtered).len());
    }
}