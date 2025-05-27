function findUnique(v) {
    const unique = [];
    for (const i of v) {
        let isUnique = true;
        for (const j of unique) {
            if (j === i) {
                isUnique = false;
                break;
            }
        }
        if (isUnique) {
            unique.push(i);
        }
    }
    return unique;
}

function format(s) {
    let result = '';
    let seenAt = false;
    let seenStar = false;
    
    for (const c of s) {
        if (c === '@') seenAt = true;
        if (!seenAt) {
            if (c === '*') {
                seenStar = true;
                continue;
            }
            if (seenStar) continue;
            if (c === '.') continue;
        }
        result += c;
    }
    return result;
}

function isAllowed(s) {
    const notAllowedChars = ['&', '=', '+', '-', '_', '<', '>', ',', "'"];
    
    if (s.length === 0 || s[0] === '.') return false;
    if (!s.includes('@')) return false;
    
    const atIndex = s.indexOf('@');
    if (atIndex < 6 || atIndex > 30) return false;
    
    for (let i = 0; i < atIndex; i++) {
        if (notAllowedChars.includes(s[i])) return false;
    }
    
    const lastDot = s.lastIndexOf('.');
    if (lastDot <= atIndex || lastDot === -1) return false;
    
    return true;
}

function main() {
    let v = [".555555@.", "123456*7890@.mailru", "123456@.mailru", "123456@.mailru", "1234567@.mailru"];
    
    v = v.filter(email => {
        if (!isAllowed(email)) return false;
        return true;
    }).map(format);
    
    if (v.length === 0) {
        console.log("No unique emails");
    } else {
        console.log(findUnique(v).length);
    }
}

main(); 