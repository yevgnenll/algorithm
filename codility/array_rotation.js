function solution(A, K) {
    var array_length = A.length;
    var rotation_count = K % array_length;

    for(var i=0; i<rotation_count; i++){
        var rotated_num = A.pop();
        A.unshift(rotated_num);
    }
    return A;
}
