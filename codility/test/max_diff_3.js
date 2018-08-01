Array.prototype.max = function(){
    return Math.max.apply(null, this);
}

function solution(arr){

    var len = arr.length;
    if(len === 0) return 0;
    var left_max_arr = [], right_max_arr = [];
    var left_max = 0, right_max = 0;
    for(var i=0; i<len; i++){
        if(i === 0){
            left_max_arr.push(arr[i]);
            right_max_arr.push(arr[len-i-1]);
        } else {
            left_max_arr.push(Math.max(left_max_arr[i-1], arr[i]));
            right_max_arr.push(Math.max(right_max_arr[i-1], arr[len-i-1]));
        }
        console.log('left_arr', left_max, left_max_arr);
        console.log('right_arr', right_max, right_max_arr);
    }

    var max = -1 * 1000000000;
    for(var i=0; i<len; i++){
        max = Math.max(max, Math.abs(left_max_arr[i] - right_max_arr[len-i-1]));
    }

    return max;

}

console.log(solution(  [4, 3, 2, 5, 1, 1] ));
console.log(solution(    [1, 3, -3]  ));
