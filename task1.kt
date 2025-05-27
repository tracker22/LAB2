fun nulls(s: String, i: Int): Int {
    var idx = i
    while (idx < s.length && s[idx] == '0') {
        if (idx + 1 < s.length && s[idx + 1] == '1') return idx + 1
        else if (idx + 1 < s.length && s[idx + 1] != '0') return 0
        idx++
    }
    return 0
}

fun findPattern(s: String): List<String> {
    var last: Int
    val res = mutableListOf<String>()
    var i = 0
    while (i < s.length) {
        if (s[i] == '1') {
            when (s[i+1]) {
                '0' -> {
                    last = nulls(s, i + 1)
                    if (last != 0) {
                        res.add(s.substring(i, last + 1))
                        i = last
                    }
                }
                '1' -> {
                    last = nulls(s, i + 2)
                    if (last != 0) {
                        res.add(s.substring(i, last + 1))
                        i = last
                    }
                }
            }
        }
        i++
    }
    return res
}

fun main() {
    val str = "1101gdyY101tf11flb10001"
    val v = findPattern(str)
    if (v.isEmpty()) println("Not found") 
    else v.forEach { print("$it ") }
}