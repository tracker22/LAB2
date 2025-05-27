fun diff(a: Int, b: Int) = if (a > b) a - b else b - a

fun prod(n: Int): Int {
    var num = n
    var res = 1
    while (num > 0) {
        res *= num % 10
        num /= 10
    }
    return res
}

fun sumDigits(n: Int): Int {
    var num = n
    var res = 0
    while (num > 0) {
        res += num % 10
        num /= 10
    }
    return res
}

fun main() {
    print("Enter the number: ")
    val num = readLine()?.toIntOrNull() ?: 0
    if (num > 0) {
        val summary = sumDigits(num)
        val product = prod(num)
        println("$summary $product ${diff(summary, product)}")
    } else {
        println("Number is not natural")
    }
}