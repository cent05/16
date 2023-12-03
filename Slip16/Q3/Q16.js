
const EventEmitter = require('events');

//create an eventEmitter object
var eventEmitter = new EventEmitter();

var connectHandler = function connected(s){
    console.log('Its',s);
}

eventEmitter.on('data_received',function(name){
    console.log(name,"Understood event -Driven");
});
eventEmitter.emit('data_received',"ABCD XYZ");

eventEmitter.on('connection',connectHandler);
eventEmitter.emit('connection',"SIMPLE SOLUTION")

console.log("program Ended");