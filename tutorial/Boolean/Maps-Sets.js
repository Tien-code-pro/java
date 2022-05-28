let daysMap = new Map();
daysMap.set('1', 'Monday');
daysMap.set('2', 'Tuesday');
daysMap.set('3', 'Wednesday');
console.log(daysMap.size);


//set
let andy = {ename:"Andrel"},
varun = {ename:"Varun"},
prijin = {ename:"Prijin"}

let empJobs = new Map();
empJobs.set(andy,'Programmer')
empJobs.set(varun,'Accountant')
empJobs.set(prijin,'HR')

console.log(empJobs)

//get
// let andy = {ename:"Andrel"},
// varun = {ename:"Varun"},
// prijin = {ename:"Prijin"}

// let empJobs = new Map([
// [andy,'Software Architect'],
// [varun,'Developer']]
// );

// let value = empJobs.get(varun)
// console.log(value)

// console.log(empJobs.size)


//has
// let andy = {ename:"Andrel"},
// varun = {ename:"Varun"},
// prijin = {ename:"Prijin"}

// let empJobs = new Map([
// [andy,'Software Architect'],
// [varun,'Developer']]
// );

// console.log(empJobs.has(prijin))
// console.log(empJobs.size)


//values
// let andy = {ename:"Andrel"},
//       varun = {ename:"Varun"},
//       prijin = {ename:"Prijin"}

//    let empJobs = new Map([
//    [andy,'Software Architect'],
//    [varun,'Developer']]
//    );

//    for(let role of empJobs.values()){
//       console.log(role)
//    }

//entries
// let andy = {ename:"Andrel"},
//       varun = {ename:"Varun"},
//       prijin = {ename:"Prijin"}

//    let empJobs = new Map([
//    [andy,'Software Architect'],
//    [varun,'Developer']]
//    );

//    for(let row of empJobs.entries()){
//       console.log("key is ",row[0])
//       console.log("value is ",row[1])
//    }