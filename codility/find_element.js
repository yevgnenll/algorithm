function solution(A){
    A.sort(function(a, b){return a-b;});
    
    var length = A.length;
    var second_diff = A[2] - A[1];
    if(length === 1 || length === 0){ return 0;}
    var diff = A[1] - A[0];
    if(length === 2){ return (A[0] + A[1])/2 + A[0];}
    if(diff !== second_diff){return A[0] + second_diff;}

    for(var i=0; i<length-1; i++){
        var cur = A[i] + diff;
        if(cur !== A[i+1]){
            return A[i] + diff;
        }
    }
    /*
    for(var i=0; i<length-1; i++){
        var current_diff = A[i+1] - A[i];
        if(diff !== current_diff){
            second_chk = A[i+2] - A[i+1];
            if(second_chk === current_diff){
                return A[i-1] + current_diff;
            } else {
                return A[i] + diff;
            }
        }
    }
    */
}

console.log(solution([6,8,10,12,16]));
console.log(solution([3,5,6,7,8,9,10]));
console.log(solution([2,2]));
