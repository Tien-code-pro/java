var person = { 
    firstname:"Tom", 
    lastname:"Hanks", 
    func:function(){return "Hello!!"},    
 }; 
 
 console.log(person.firstname)   
 console.log(person.lastname) 
 console.log(person.func())

var foo = 'bar' 
var baz = { foo:foo } 
console.log(baz.foo)

//object contrucstor

var myCar = new Object(); 
myCar.make = "Ford"; 
myCar.model = "Mustang"; 
myCar.year = 1987;  

console.log(myCar["make"]) 
console.log(myCar["model"]) 
console.log(myCar["year"])

//contrucstor function
function Car() { 
    this.make = "Ford" 
    this.model = "F123" 
 }  
 var obj = new Car() 
 console.log(obj.make) 
 console.log(obj.model)

 