var map = new Map(); 
map.set(1,true); 
console.log(map.has("1")); //false 
map.set("1",true); 
console.log(map.has("1")); //true

//
var roles = new Map([ 
    ['r1', 'User'], 
    ['r2', 'Guest'], 
    ['r3', 'Admin'], 
 ]);  
 console.log(`value of key r1 before set(): ${roles.get('r1')}`) 
 roles.set('r1','superUser') 
 console.log(`value of key r1 after set(): ${roles.get('r1')}`)