
// const mySymbol = Symbol()
// const mySymbol = Symbol(stringDescription)

const s1 = Symbol();
const s2 = Symbol();
console.log(typeof s1)
console.log(s1===s2)
const s3 = Symbol("hello");//description
const s4 = Symbol("hello");
console.log(s3)
console.log(s4)
console.log(s3==s4)


//Symbol & Classes
const COLOR = Symbol()
   const MODEL = Symbol()
   const MAKE = Symbol()
   class Bike {
      constructor(color ,make,model){
      this[COLOR] = color;
      this[MAKE] = make;
      this[MODEL] = model;
   }
}
let bike = new Bike('red','honda','cbr')
console.log(bike)
//property can be accessed ony if symbol name is known
console.log(bike[COLOR])