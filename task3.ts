function diff(a: number, b: number): number {
    return a > b ? a - b : b - a;
}

function prod(n: number): number {
    let res: number = 1;
    while (n > 0) {
        res *= n % 10;
        n = Math.floor(n / 10);
    }
    return res;
}

function sumDigits(n: number): number {
    let res: number = 0;
    while (n > 0) {
        res += n % 10;
        n = Math.floor(n / 10);
    }
    return res;
}

function main(): void {
    const input: string | null = prompt("Enter the number: ");
    const num: number = input ? parseInt(input) : 0;
    
    if (num > 0) {
        const summary: number = sumDigits(num);
        const product: number = prod(num);
        console.log(`${summary} ${product} ${diff(summary, product)}`);
    } else {
        console.log("Number is not natural");
    }
}

main();