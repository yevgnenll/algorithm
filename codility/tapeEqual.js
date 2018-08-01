function solution(A){
    n = A.length;
    if(n === 1)
        return Math.abs(A[0]);
    if(n === 2)
        return Math.abs(A[0]-A[1]);

    var total_array = arr_sum(A);
    var min_abs = false;
    var left = 0, right = 0;

    for(var i=1; i<n-1; i++){
        left += A[i-1]; 
        right = total_array - left;
        current_abs = Math.abs(left - right);
        min_abs = min_abs !== false ? (min_abs < current_abs ? min_abs : current_abs): current_abs;
    }
    return min_abs;
}

function arr_sum(arr){
    var total = 0;
    for(var i in arr){
        total += arr[i];
    }
    return total;
}

console.log(solution([-10, -5, -3, -4, -5]));
