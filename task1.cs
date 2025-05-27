using System;
using System.Collections.Generic;

class Program {
    static int Nulls(string s, int i) {
    	while (i < s.Length && s[i] == '0') {
    		if (i + 1 < s.Length && s[i + 1] == '1') return i + 1;
    		else if (i + 1 < s.Length && s[i + 1] != '0') return 0;
    		i++;
    	}
    	return 0;
    }
    
    static List<string> FindPattern(string s) {
    	int last;
    	var res = new List<string>();
    	for (int i = 0; i < s.Length; i++) {
    		if (s[i] == '1') {
    		    switch(s[i+1]){
        			case '0':
        				last = Nulls(s, i + 1);
        				if (last != 0) {
        					res.Add(s.Substring(i, last - i + 1));
        					i = last;
        				}
        				break;
        			case '1':
        				last = Nulls(s, i + 2);
        				if (last != 0) {
        					res.Add(s.Substring(i, last - i + 1));
        					i = last;
        				}
        				break;
        			default: break;
    		    }
    		}
    	}
    	return res;
    }
    
    static void Main() {
    	string str = "1101gdyY101tf11flb10001";
    	var v = FindPattern(str);
    	if (v.Count == 0) Console.WriteLine("Not found");
    	else foreach (var item in v) Console.Write(item + " ");
    }
}