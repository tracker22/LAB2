func writer(_ s: String, _ start: Int, _ end: Int) -> String {
    let startIndex = s.index(s.startIndex, offsetBy: start)
    let endIndex = s.index(s.startIndex, offsetBy: end)
    return String(s[startIndex...endIndex])
}

func nulls(_ s: String, _ i: Int) -> Int {
    var idx = i
    while idx < s.count && Array(s)[idx] == "0" {
        if idx + 1 < s.count && Array(s)[idx + 1] == "1" {
            return idx + 1
        } else if idx + 1 < s.count && Array(s)[idx + 1] != "0" {
            return 0
        }
        idx += 1
    }
    return 0
}

func findPattern(_ s: String) -> [String] {
    var res = [String]()
    var i: Int = 0
    while i < s.count {
        if Array(s)[i] == "1" {
            switch Array(s)[i+1]{
                case "0":
                let last = nulls(s, i + 1)
                if last != 0 {
                    res.append(writer(s, i, last))
                    i = last
                }
                case "1":
                let last = nulls(s, i + 1)
                if last != 0 {
                    res.append(writer(s, i, last))
                    i = last
                }
                default:
                break
            }
            
        }
        i += 1
    }
    return res
}

let str = "1101gdyY101tf11flb10001"
let v = findPattern(str)
if v.isEmpty {
    print("Not found")
} else {
    v.forEach { print($0, terminator: " ") }
}