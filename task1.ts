function nulls(s: string, i: number): number {
    while (i < s.length && s[i] === '0') {
        if (s[i + 1] === '1') return i + 1;
        else if (s[i + 1] !== '0') return 0;
        i++;
    }
    return 0;
}

function findPattern(s: string): string[] {
    const res: string[] = [];
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '1') {
            if (s[i + 1] === '0') {
                const last = nulls(s, i + 1);
                if (last) {
                    res.push(s.substring(i, last + 1));
                    i = last;
                }
            } else if (s[i + 1] === '1') {
                const last = nulls(s, i + 2);
                if (last) {
                    res.push(s.substring(i, last + 1));
                    i = last;
                }
            }
        }
    }
    return res;
}

const str = "1101gdyY101tf11flb10001";
var v: string[] = findPattern(str);
if (v.length === 0) console.log("Not found");
else console.log(v.join(' '));  