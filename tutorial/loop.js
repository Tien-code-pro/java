//for loop
var num = 5
var factorial=1;
for( let i = num ; i >= 1; i-- ) {
   factorial *= i ;
}
console.log(factorial);

// for in loop
var obj = {a:1, b:2, c:3};

for (var prop in obj) {
   console.log(obj[prop]);
}

//for…of loop

for (let val of[12 , 13 , 123]){
    console.log(val)
 }


 //while loop

 var num = 5;
var factorial = 1;
while(num >=1) {
factorial = factorial * num;
num--;
}
console.log("The factorial is "+factorial);

//do…while loop
var n = 10;
do {
   console.log(n);
   n--;
}
while(n >= 0);


//break statement
var i = 1
while(i <= 10) {
   if (i % 5 == 0) {
      console.log("The first multiple of 5 between 1 and 10 is : "+i)
      break //exit the loop if the first multiple is found
   }
   i++
}

//Label with Break

outerloop: // This is the label name
for (var i = 0; i < 5; i++) {
   console.log("Outerloop: " + i);
   innerloop:
   for (var j = 0; j < 5; j++){
      if (j > 3 ) break ; // Quit the innermost loop
      if (i == 2) break innerloop; // Do the same thing
      if (i == 4) break outerloop; // Quit the outer loop
      console.log("Innerloop: " + j);
   }
}