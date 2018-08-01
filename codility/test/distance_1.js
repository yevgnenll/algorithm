function solution(arr){

    arr.sort(function(a, b){return a-b;});
    if(arr.length === 0){
        return 0;
    }
   if(arr.length === 1){
        return arr[0];
    }
    if(arr.length === 2){
        return arr[1] - arr[0];
    }

    console.log(arr);
    var min = 1000000;

    for(var i=arr.length-1; i>=1; i--){
        var diff = arr[i] - arr[i-1];
        if(min > diff){
            min = diff;
        }
    }
    return min;

}

/*
console.log(solution([1,0]));
console.log(solution([0]));
console.log(solution([1,2,3,4]));
*/
console.log(solution([1, 21, 3, 42, 9, 7,42] ));
console.log(solution([1, 10000,10001,10002] ));
console.log(solution([1,100,200,300,400,500] ));
