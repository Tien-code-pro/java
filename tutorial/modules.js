// let company = "TutorialsPoint"

// let getCompany = function(){
//    return company.toUpperCase()
// }

// let setCompany = function(newValue){
//    company = newValue
// }

// export {company,getCompany,setCompany}

let name = 'TutorialsPoint'

let company = {
   getName:function(){
      return name
   },
   setName:function(newName){
      name = newName
   }
}

export default company