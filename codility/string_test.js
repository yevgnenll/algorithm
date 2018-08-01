String.prototype.stripWhiteSpace = function(){
    var res = [];
    for(var i = 0; i < this.length; i++) {
       var tempChar = this.charAt(i);
       if( tempChar != ' ') {
          res.push(tempChar);
       }
    }
    return res.join("");
} 
