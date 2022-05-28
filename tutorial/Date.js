// new Date( )
// new Date(milliseconds)
// new Date(datestring)
// new Date(year,month,date[,hour,minute,second,millisecond ])


//Constructor
var dt = new Date(); 
console.log("dt.constructor is : " + dt.constructor); 

//Date() Method

var dt = Date(); 
console.log("Current Date ",dt); 

//getDay
var dt = new Date("December 25, 1995 23:15:00"); 
console.log("getDay() : " + dt.getDay());  

//getFullYear
var dt = new Date("December 25, 1995 23:15:00"); 
console.log("getFullYear() : " + dt.getFullYear());  

// getHours
var dt = new Date("December 25, 1995 23:15:00"); 
console.log("getHours() : " + dt.getHours());


//setDate
var dt = new Date( "Aug 28, 2008 23:30:00" ); 
dt.setDate( 24 ); 
console.log( dt ) 

//setHours

var dt = new Date( "Aug 28, 2008 23:30:00" ); 
dt.setHours(02); 
console.log(dt);

// setMonth
var dt = new Date( "Aug 28, 2008 23:30:00" ); 
dt.setMonth( 2 ); 
console.log( dt ); 