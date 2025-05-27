fun findUnique(v: List<String>): List<String> {
    val unique = mutableListOf<String>()
    for (i in v) {
        var isUnique = true
        for (j in unique) {
            if (j == i) {
                isUnique = false
                break
            }
        }
        if (isUnique) unique.add(i)
    }
    return unique
}

fun format(s: String): String {
    var result = s
    var iter = 0
    while (iter < result.length && result[iter] != '@') {
        if (result[iter] == '*') {
            while (iter < result.length && result[iter] != '@') {
                result = result.removeRange(iter, iter + 1)
            }
        } else if (result[iter] == '.') {
            result = result.removeRange(iter, iter + 1)
        } else {
            iter++
        }
    }
    return result
}

fun isAllowed(s: String): Boolean {
    val notAllowedChars = charArrayOf('&', '=', '+', '-', '_', '<', '>', ',', '\'')
    if (s.isEmpty() || s[0] == '.') return false
    if (!s.contains('@')) return false
    
    val atIndex = s.indexOf('@')
    if (atIndex < 6 || atIndex > 30) return false
    
    for (i in 0 until atIndex) {
        if (s[i] in notAllowedChars) return false
    }
    
    if (s.lastIndexOf('.') <= atIndex || !s.contains('.')) return false
    return true
}

fun main() {
    val v = listOf(".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru")
    val filtered = v.filter { isAllowed(it) }.map { format(it) }
    if (filtered.isEmpty()) println("No unique emails")
    else println(findUnique(filtered).size)
}