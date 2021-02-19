"use strict";

// Hckerrank A Very Big Sum
// https://www.hackerrank.com/challenges/a-very-big-sum/problem
const fs = require("fs");

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => {
  inputString += inputStdin;
});

process.stdin.on("end", (_) => {
  inputString = inputString
    .replace(/\s*$/, "")
    .split("\n")
    .map((str) => str.replace(/\s*$/, ""));

  main();
});

function readLine() {
  return inputString[currentLine++];
}

// Complete the aVeryBigSum function below.
function aVeryBigSum(ar) {
  let result = 0;
  for (let i = 0; i < ar.length; i++) {
    result += ar[i];
    // console.log(result)
  }
  // console.log(result)
  return result;
}

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  const arCount = parseInt(readLine(), 10);

  const ar = readLine()
    .split(" ")
    .map((arTemp) => parseInt(arTemp, 10));

  let result = aVeryBigSum(ar);

  ws.write(result + "\n");

  ws.end();
}
