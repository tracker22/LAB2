func findUnique(_ v: [String]) -> [String] {
    return Array(Set(v))
}

func formatEmail(_ s: String) -> String {
    var result = ""
    var seenAt = false
    var seenStar = false
    
    for c in s {
        if c == "@" { seenAt = true }
        if !seenAt {
            if c == "*" { seenStar = true; continue }
            if seenStar { continue }
            if c == "." { continue }
        }
        result.append(c)
    }
    return result
}

func isAllowed(_ s: String) -> Bool {
    let notAllowedChars: [Character] = ["&", "=", "+", "-", "_", "<", ">", ",", "'"]
    if s.isEmpty || s.first == "." { return false }
    if !s.contains("@") { return false }
    
    let atIndex = s.firstIndex(of: "@")!.utf16Offset(in: s)
    if atIndex < 6 || atIndex > 30 { return false }
    
    for c in s.prefix(atIndex) {
        if notAllowedChars.contains(c) { return false }
    }
    
    guard let lastDot = s.lastIndex(of: ".") else { return false }
    if lastDot.utf16Offset(in: s) <= atIndex { return false }
    return true
}

let v = [".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru"]
let filtered = v.filter(isAllowed).map(formatEmail)
if filtered.isEmpty {
    print("No unique emails")
} else {
    print(findUnique(filtered).count)
}