
//Variables
var name = "Tom" 
console.log("The value in the variable is: "+name)

//Global vs. Local Variable
var num = 10 
function test() { 
   var num = 100 
   console.log("value of num in test() "+num) 
} 
console.log("value of num outside test() "+num) 
test()

//let and multiple blocks
let count = 100
    for (let count = 1;count <= 10;count++){
       //inside for loop brackets ,count value starts from 1
       console.log("count value inside loop is ",count);
    }
    //outside for loop brackets ,count value is 100
    console.log("count value after loop is",count);
 
    if(count == 100){
       //inside if brackets ,count value is 50
       let count = 50;
       console.log("count inside if block",count);
    }
    console.log(count);

    
