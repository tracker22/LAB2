package main

import "fmt"

func writer(s string, start int, end int) string {
	return s[start : end+1]
}

func nulls(s string, i int) int {
	for i < len(s) && s[i] == '0' {
		if i+1 < len(s) && s[i+1] == '1' {
			return i + 1
		} else if i+1 < len(s) && s[i+1] != '0' {
			return 0
		}
		i++
	}
	return 0
}

func findPattern(s string) []string {
	var res []string
	for i := 0; i < len(s); i++ {
		if s[i] == '1' {
			if i+1 < len(s) && s[i+1] == '0' {
				last := nulls(s, i+1)
				if last != 0 {
					res = append(res, s[i : last+1])
					i = last
				}
			} else if i+1 < len(s) && s[i+1] == '1' {
				last := nulls(s, i+2)
				if last != 0 {
					res = append(res, s[i : last+1])
					i = last
				}
			}
		}
	}
	return res
}

func main() {
	str := "1101gdyY101tf11flb10001"
	v := findPattern(str)
	if len(v) == 0 {
		fmt.Println("Not found")
	} else {
		for _, item := range v {
			fmt.Printf("%s ", item)
		}
	}
} 