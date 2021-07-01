let inputUndefine;
let inputNull = null;
let inputEmptyString = "";
let inputObject = {};
let inputEmptyArray = [];

console.log("Contruction ... ? ... : ...");
console.log(inputUndefine ? inputUndefine : null);
console.log(inputNull ? inputNull : null);
console.log(inputEmptyString ? inputEmptyString : null);
console.log(inputObject ? inputObject : null);
console.log(inputEmptyArray ? inputEmptyArray : null);

console.log("Contruction ... || ...");
console.log(inputUndefine || null);
console.log(inputNull || null);
console.log(inputEmptyString || null);
console.log(inputObject || null);
console.log(inputEmptyArray || null);
