package main

import "fmt"

func diff(a, b int) int {
	if a > b {
		return a - b
	}
	return b - a
}

func prod(n int) int {
	res := 1
	for n > 0 {
		res *= n % 10
		n /= 10
	}
	return res
}

func sumDigits(n int) int {
	res := 0
	for n > 0 {
		res += n % 10
		n /= 10
	}
	return res
}

func main() {
	var num int
	fmt.Print("Enter the number: ")
	fmt.Scan(&num)
	if num > 0 {
		summary := sumDigits(num)
		product := prod(num)
		fmt.Printf("%d %d %d\n", summary, product, diff(summary, product))
	} else {
		fmt.Println("Number is not natural")
	}
}