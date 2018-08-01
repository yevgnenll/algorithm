function solution(arr){

    var height = 0, cnt = 0;

    for(var i=0; i<arr.length; i++){

        if(height < arr[i]){
            cnt += (arr[i] - height);
        }
        height = arr[i];

        if(cnt > 100000000)
            return -1;
    }

    return cnt;
}

console.log(solution([100, 0, 100]));
console.log(solution([1, 3, 2, 1, 2, 3, 4, 1]));
