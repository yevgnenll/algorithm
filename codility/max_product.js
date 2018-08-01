function solution(arr){
    if(arr.length === 3){
        return arr[0] * arr[1] * arr[2];
    }

    var positive_res = find_triplet_product(arr.slice());
    var negative_res = check_negative(arr.slice());

    return Math.max(positive_res, negative_res);

}

function find_triplet_product(arr){
    arr.sort(function(a, b){return a-b});
    var arr_length = arr.length;
    var res = arr.slice(arr_length-3, arr_length);
    return res[0] * res[1] * res[2];
}

function check_negative(arr){
    arr.sort(function(a, b){return a-b});
    for(var i=0; i<arr.length; i++){
        if(arr[i] >= 0){
            break;
        }
    }
    if(i < 1)
        return 0; // all of array is negative
    if(i < 2)
        return -1000; // one element is negative

    var negative_arr = arr.slice(0, i);
    var the_other = arr.slice(i, arr.length);
    var n_len = negative_arr.length;
    // console.log('negative_arr', negative_arr, 'the_other', the_other);

    if(the_other.length === 0){
        return negative_arr[n_len -1] * negative_arr[n_len-2] *negative_arr[n_len-3]
    }
    

    return negative_arr[0] * negative_arr[1] * the_other[the_other.length-1];
}

console.log(solution([2, 100, 3, -1000]));
console.log(solution([-5,5,-4,1]));
console.log(solution([-1,-4,-3,-2,-6,-5]));
console.log(solution([4,5,1,0]));
console.log(solution([-5, -9, 3, 4, 2]));
console.log(solution([-3, 1,2,-2,5,6]))

