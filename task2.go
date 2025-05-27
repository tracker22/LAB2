package main

import (
	"fmt"
	"strings"
)

func findUnique(v []string) []string {
	unique := make(map[string]bool)
	var result []string
	for _, s := range v {
		if !unique[s] {
			unique[s] = true
			result = append(result, s)
		}
	}
	return result
}

func formatEmail(s string) string {
	var result strings.Builder
	seenAt := false
	seenStar := false
	
	for _, c := range s {
		if c == '@' {
			seenAt = true
		}
		if !seenAt {
			if c == '*' {
				seenStar = true
				continue
			}
			if seenStar {
				continue
			}
			if c == '.' {
				continue
			}
		}
		result.WriteRune(c)
	}
	return result.String()
}

func isAllowed(s string) bool {
	notAllowedChars := []rune{'&', '=', '+', '-', '_', '<', '>', ',', '\''}
	if len(s) == 0 || s[0] == '.' {
		return false
	}
	if !strings.Contains(s, "@") {
		return false
	}
	
	atIndex := strings.Index(s, "@")
	if atIndex < 6 || atIndex > 30 {
		return false
	}
	
	for _, c := range s[:atIndex] {
		for _, bad := range notAllowedChars {
			if c == bad {
				return false
			}
		}
	}
	
	lastDot := strings.LastIndex(s, ".")
	if lastDot <= atIndex || !strings.Contains(s, ".") {
		return false
	}
	return true
}

func main() {
	v := []string{".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru"}
	var filtered []string
	for _, email := range v {
		if isAllowed(email) {
			filtered = append(filtered, formatEmail(email))
		}
	}
	if len(filtered) == 0 {
		fmt.Println("No unique emails")
	} else {
		fmt.Println(len(findUnique(filtered)))
	}
}