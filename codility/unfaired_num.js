function solution(A){
    if(A.length === 1)
        return A[0];
    A = A.sort();
    var xor = 0;
    for(var i=0; i<A.length; i++){
        console.log('xor' , xor^A[i], 'xor:',xor, A[i]);
        xor = xor ^ A[i];
        
    }
    return xor
}
console.log(solution([9,3,9,3,7]));
