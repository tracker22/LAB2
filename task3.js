const readline = require('readline');

function diff(a, b) {
  return a > b ? a - b : b - a;
}

function prod(n) {
  let res = 1;
  while (n > 0) {
    res *= n % 10;
    n = Math.floor(n / 10);
  }
  return res;
}

function sumDigits(n) {
  let res = 0;
  while (n > 0) {
    res += n % 10;
    n = Math.floor(n / 10);
  }
  return res;
}

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("Enter the number: ", (input) => {
  const num = parseInt(input) || 0;
  if (num > 0) {
    const summary = sumDigits(num);
    const product = prod(num);
    console.log(`${summary} ${product} ${diff(summary, product)}`);
  } else {
    console.log("Number is not natural");
  }
  rl.close();
});