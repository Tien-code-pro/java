  
   function add_positivenos_async(n1, n2) {
      let p = new Promise(function (resolve, reject) {
         if (n1 >= 0 && n2 >= 0) {
            //do some complex time consuming work
            resolve(n1 + n2)
         }
         else
            reject('NOT_Postive_Number_Passed') 
         })
         return p;
   }

   add_positivenos_async(10, 20)
      .then(successHandler) // if promise resolved
      .catch(errorHandler);// if promise rejected

   add_positivenos_async(-10, -20)
      .then(successHandler) // if promise resolved
      .catch(errorHandler);// if promise rejected

   function errorHandler(err) {
      console.log('Handling error', err)
   }
   function successHandler(result) {
      console.log('Handling success', result)
   }

   console.log('end')

   
   
   //Promises Chaining


   function add_positivenos_async(n1, n2) {
    let p = new Promise(function (resolve, reject) {
       if (n1 >= 0 && n2 >= 0) {
          //do some complex time consuming work
          resolve(n1 + n2)
       }
       else
          reject('NOT_Postive_Number_Passed')
    })
    return p;
 }

 add_positivenos_async(10,20)
 .then(function(result){
    console.log("first result",result)
    return add_positivenos_async(result,result)
 }).then(function(result){
 console.log("second result",result)
    return add_positivenos_async(result,result)
 }).then(function(result){
    console.log("third result",result)
 })

 console.log('end')
