function solution(arr){

    var cur_height = 0, strokes = 0;
    var level = 0;

    for(var i=0; i<arr.length; i++){
        if(cur_height < arr[i]){
            strokes += (arr[i] - cur_height);
            cur_height = arr[i];
        } else if( cur_height > arr[i] ){
            cur_height = arr[i];
        }
        if(strokes > 1000000000){
            return -1;
        }
    }

    return strokes;
}

console.log(solution([100, 0, 100]));
console.log(solution([1, 3, 2, 1, 2, 3, 4, 1]));
