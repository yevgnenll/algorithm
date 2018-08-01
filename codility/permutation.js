function solution(A){
    if(!A instanceof Array){return 0;}
    if(A.length === 1 && A[0] === 1){
        return 1;
    }
    if(A.length === 1){return 0;}
    if(A.length === 0){return 1;}
    
    A.sort(function(a,b){return a-b;});
    var diff = A[1]-A[0];
    if(diff === 0)
        return 0;
    var xor = diff;
    for(var i=0; i<A.length-1; i++){
        diff = A[i+1]-A[i];
        xor ^= diff;
        
        if(xor !== 0){
            return 0;
        }
        xor ^= diff;
    }
    return 1;
}
