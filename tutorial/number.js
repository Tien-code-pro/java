// let suffix = 'Name'
// let company = {
//    ['first'+suffix]:'Tien',
//    ['last'+suffix]:'Dat'
// }
// console.log(company)
// console.log(company['firstName'])
// console.log(company['lastName'])



let firstName = 'Tien',lastName='Dat'
   let company = {
      firstName,
      lastName,
      getFullName(){
         return this.firstName+" - "+this.lastName
      }
   }
   console.log(company.getFullName())
   console.log(company)