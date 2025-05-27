use std::io;

fn diff(a: i32, b: i32) -> i32 {
    if a > b { a - b } else { b - a }
}

fn prod(mut n: i32) -> i32 {
    let mut res = 1;
    while n > 0 {
        res *= n % 10;
        n /= 10;
    }
    res
}

fn sum_digits(mut n: i32) -> i32 {
    let mut res = 0;
    while n > 0 {
        res += n % 10;
        n /= 10;
    }
    res
}

fn main() {
    println!("Enter the number: ");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let num: i32 = input.trim().parse().unwrap_or(0);
    
    if num > 0 {
        let summary = sum_digits(num);
        let product = prod(num);
        println!("{} {} {}", summary, product, diff(summary, product));
    } else {
        println!("Number is not natural");
    }
}