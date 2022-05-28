//constructor 

var str = new String( "This is string" );
console.log("str.constructor is:" + str.constructor)

//indexOf
var str1 = new String( "This is string one" );
var index = str1.indexOf( "string" );
console.log("indexOf found String :" + index );
var index = str1.indexOf( "one" );
console.log("indexOf found String :" + index );

//search
var re = /apples/gi;
var str = "Apples are round, and apples are juicy."; 
if ( str.search(re) == -1 ) { 
   console.log("Does not contain Apples" ); 
} else { 
   console.log("Contains Apples" ); 
}  

//toString
var str = "Apples are round, and Apples are Juicy."; 
console.log(str.toString( )); 

//valueOf
var str = new String("Hello world"); 
console.log(str.valueOf( )); 