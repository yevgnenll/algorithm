function solution(arr){
    if(arr.length === 0){return -1;}
    var total_arr = sum_arr(arr);
    var left = 0, right = 0;
    for(var i=0; i<arr.length; i++){
        left += arr[i];
        right = total_arr - left - arr[i+1];
        console.log(left, right);
        if( left === right ){
            return i+1;
        }
    }
    return -1;
}

function sum_arr(arr){
    var total = 0;
    for(var i=0; i<arr.length; i++){
        total += arr[i];
    }
    console.log('total', total);
    return total;
}

console.log(solution([0]));
