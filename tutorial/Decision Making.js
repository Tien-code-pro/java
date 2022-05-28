//if-else

var num=2
if(num > 0) {
console.log(num+" is positive")
} else if(num < 0) {
console.log(num+" is negative")
} else {
console.log(num+" is neither positive nor negative")
}

// switch…case

var grade="A";
switch(grade) {
   case "A": {
      console.log("Excellent");
      break;
   }
   case "B": {
      console.log("Good");
      break;
   }
   case "C": {
      console.log("Fair");
      break;
   }
   case "D": {
      console.log("Poor");
      break;
   }
   default: {
      console.log("Invalid choice");
      break;
   }
}
