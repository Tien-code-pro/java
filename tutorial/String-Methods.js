var name = "Brendan"; 
console.log('Hello, ${name}!');

//Template literals and expressions
var a = 10; 
var b = 10; 
console.log(`The sum of ${a} and ${b} is  ${a+b} `);

//Multiline Strings
var multiLine = 
  `This is 
   a string 
   with multiple 
   lines`; 
console.log(multiLine)


//Tagged 
function myTagFn(literals,...values){
    console.log("literal values are");
    for(let c of literals){
    console.log(c)
    }
    
    console.log("variable values are ");
    for(let c of values){
    console.log(c)
    }
    
    return "Done"
    }
    let company = `TutorialsPoint`
    let company_location = `Mumbai`
    let result = myTagFn `Hello this is ${company} from ${company_location}`
    
    console.log(result)