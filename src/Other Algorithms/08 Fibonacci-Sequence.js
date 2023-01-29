function fib(num) {
	const numbers = [1, 1];

	for (let i = 2; i < num + 1; ++i) {
		numbers.push(numbers[i - 2] + numbers[i - 1]);
	}

	return numbers;
}

console.log(fib(6));
