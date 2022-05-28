//Reflect.apply()
const areaOfRectangle = function(width,height){
    return `area is ${width*height} ${this.units}`
 }
 const thisValue = {
    units:'Centimeters'
 }
 const argsList = [10,20]
 const result = Reflect.apply(areaOfRectangle,thisValue,argsList)

 console.log(result)

//Reflect.construct
//  class Student{
//     constructor(firstName,lastName){
//        this.firstName = firstName
//        this.lastName = lastName
//     }
    
//     get fullName(){
//        return `${this.firstName} : ${this.lastName}`
//     }
//  }
 
//  const args = ['Mohammad','Mohtashim']
//  const s1 = Reflect.construct(Student,args)
 
//  console.log(s1.fullName)
//

// class Student{
//     constructor(firstName,lastName){
//        this.firstName = firstName
//        this.lastName = lastName
//     }
//     get fullName(){
//        return `${this.firstName} : ${this.lastName}`
//     }
//  }

//  const args = ['Tutorials','']
//  const s1 = Reflect.construct(Student,args)
//  console.log('fullname is ',Reflect.get(s1,'fullName'))
//  //setting value
//  Reflect.set(s1,'lastName','Point')
//  console.log('fullname is ',Reflect.get(s1,'fullName'))


//Reflect.has
 class Student{
    constructor(firstName,lastName){
       this.firstName = firstName
       this.lastName = lastName
    }
    get fullName(){
       return `${this.firstName} : ${this.lastName}`
    }
 }

 const args = ['Tutorials','Point']
 const s1 = Reflect.construct(Student,args)
 console.log(Reflect.has(s1,'fullName'))
 console.log(Reflect.has(s1,'firstName'))