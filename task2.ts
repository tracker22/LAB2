function findUnique(v: string[]): string[] {
    return [...new Set(v)];
}

function formatEmail(s: string): string {
    let result = '';
    let seenAt = false;
    let seenStar = false;
    
    for (const c of s) {
        if (c === '@') seenAt = true;
        if (!seenAt) {
            if (c === '*') { seenStar = true; continue; }
            if (seenStar) continue;
            if (c === '.') continue;
        }
        result += c;
    }
    return result;
}

function isAllowed(s: string): boolean {
    const notAllowedChars = ['&', '=', '+', '-', '_', '<', '>', ',', "'"];
    if (!s || s[0] === '.') return false;
    if (!s.includes('@')) return false;
    
    const atIndex = s.indexOf('@');
    if (atIndex < 6 || atIndex > 30) return false;
    
    for (const c of s.substring(0, atIndex)) {
        if (notAllowedChars.includes(c)) return false;
    }
    
    if (s.lastIndexOf('.') <= atIndex || !s.includes('.')) return false;
    return true;
}

const v = [".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru"];
const filtered = v.filter(isAllowed).map(formatEmail);
if (filtered.length === 0) console.log("No unique emails");
else console.log(findUnique(filtered).length);