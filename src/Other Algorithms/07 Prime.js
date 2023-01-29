/** @format */

function isPrime(num) {
	for (let i = 2; i <= num / 2; i++) {
		if (num % i === 0) {
			return false;
		}
	}
	return true;
}

console.log(isPrime(5));

function isPrime(num) {
	for (let i = 2; i <= Math.sqrt(num); i++) {
		if (num % i === 0) {
			return false;
		}
	}
	return true;
}

console.log(isPrime(5));
