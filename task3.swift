func diff(_ a: Int, _ b: Int) -> Int {
    return a > b ? a - b : b - a
}

func prod(_ n: Int) -> Int {
    var num = n
    var res = 1
    while num > 0 {
        res *= num % 10
        num /= 10
    }
    return res
}

func sumDigits(_ n: Int) -> Int {
    var num = n
    var res = 0
    while num > 0 {
        res += num % 10
        num /= 10
    }
    return res
}

print("Enter the number: ", terminator: "")
if let input = readLine(), let num = Int(input), num > 0 {
    let summary = sumDigits(num)
    let product = prod(num)
    print("\(summary) \(product) \(diff(summary, product))")
} else {
    print("Number is not natural")
}