function addTwoNumbers(first,second = 10){
    console.log('first parameter is :',first)
    console.log('second parameter is :',second)
    return first+second;
}

console.log("case 1 sum:",addTwoNumbers(20)) // no value
console.log("case 2 sum:",addTwoNumbers(2,3))
console.log("case 3 sum:",addTwoNumbers())
console.log("case 4 sum",addTwoNumbers(1,null))//null passed
console.log("case 5 sum",addTwoNumbers(3,undefined))

//vidu2
var func = new Function("x", "y", "return x*y;"); 
function product() { 
var result; 
result = func(10,20); 
console.log("The product : "+result)
} 
product()

//functions
//vidu1
function factorial(num){
    if(num <= 0){
        return 1;
    }else{
        return(num* factorial(num-1))
    }
}
console.log(factorial(6))

//2
// (function(){
//     var msg = "hello wworld"
//     console.log(msg)
// })()

//iife1
var main = function(){
    var loop = function(){
        for(var x = 0; x< 5; x++){
            console.log(x);
        }
    }();
    console.log("x can not be accessed outside the block scope x value is :"+x); 
}
main();


//iife2
var main = function(){
    (function(){
        for(var x = 0; x< 9; x++){
            console.log(x);
        }
    })();
    console.log("x can not be accessed outside the block scope x value is :"+x); 
}
main();

// generator
function * rainbow(){
    yield 'red';
    yield 'orange';
    yield 'yellow';
    yield 'green'; 
    yield 'blue'; 
    yield 'indigo'; 
    yield 'violet';
}
for(let color of rainbow()){
    console.log(color);
}

//Consider
function* ask() { 
    const name = yield "What is your name?"; 
    const sport = yield "What is your favorite sport?"; 
    return `${name}'s favorite sport is ${sport}`; 
 }  
 const it = ask(); 
 console.log(it.next()); 
 console.log(it.next('Ethan'));  
 console.log(it.next('Cricket')); 


 //Arrow function 

 const add =(n1,n2)=> n1+n2
 console.log(add(10,20))

 const isEven = (n1)=>{
     if(n1%2 == 0)
     return true;
     else
     return false;
 }
 console.log(isEven(10))
