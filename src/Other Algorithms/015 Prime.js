function checkPrime(num) {
  // 1 is not a prime number
  // any number less than one is not prime
  if (num <= 1) {
    return false;
  }
  // 2 and 3 are prime numbers
  if (num === 2 || num === 3) {
    return true;
  }
  // Any number divisible by 2 or 3 is not a prime number
  if (num % 2 === 0 || num % 3 === 0) {
    return false;
  }

  // Check for divisibility by numbers from 4 to the square root of the number
  for (let i = 4; i <= Math.sqrt(num); i++) {
    if (num % i === 0) {
      return false;
    }
  }

  // If the number is not divisible by any number, it is a prime number
  return true;
}

console.log(checkPrime(-7)); // false
console.log(checkPrime(1)); // false
console.log(checkPrime(2)); // true
console.log(checkPrime(4)); // false
console.log(checkPrime(5)); // true
