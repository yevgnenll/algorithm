Array.prototype.min = function(){
    return Math.min.apply(null, this);
};
Array.prototype.max = function(){
    return Math.max.apply(null, this);
}

function solution(arr){

}


function find(arr){
    var length = arr.length;
    if(length === 2){
        return arr[0] + arr[1];
    }

    var max = arr.min();
    for(var i=1; i< length -1; i++){
        if(max + arr[i]>= max){
            max = arr[i];
        } else {
            continue;
        }
    }
    return max + arr[length-1];
}

console.log(solution([0, -4, -5, -2, -7, -9, -3, -10]));
