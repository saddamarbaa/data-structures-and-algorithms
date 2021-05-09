

// Program to find whether a no is power of two

function isPowerOfTwo(number){
  if(number < 1)return false;
  let dividedNumber = number;
  
  while(dividedNumber !== 1){
    // console.log(dividedNumber);
    
    if(dividedNumber % 2 !== 0){
      return false;
    }
    dividedNumber = dividedNumber / 2;
  }
  return true;
}

   console.log(isPowerOfTwo(10));
   console.log(isPowerOfTwo(8));
   console.log(isPowerOfTwo(5));
   console.log(isPowerOfTwo(20));
   console.log(isPowerOfTwo(16));
