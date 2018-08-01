Array.prototype.max = function(){
    return Math.max.apply(null, this);
}

function solution(arr){

    var arr_length = arr.length;

    if(arr_length === 2){
        return Math.abs(arr[0] - arr[1]);
    }

    var left = 0, right = 0;
    var max = 1000000000 * -1;

    for(var i=1; i<arr_length; i++){
        var left_arr = arr.slice(0,i);
        var right_arr = arr.slice(i, arr_length);

        left = left_arr.max();
        right = right_arr.max();

        max = Math.max(max, Math.abs(left-right));
    }
    return max;

}



console.log(solution([1,2,3,4,5]));
console.log(solution([2,2]));
