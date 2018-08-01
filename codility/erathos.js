function solution(start, end){
    var numbers = init_arr(end);
    var res = [];
    for(var i=2; i<numbers.length; i++){
        if(numbers[i]){
            continue;
        }
        res.push(i);
        for(var j=i*i; j<end+1; j+=i){
            numbers[j] = true;
        }
    }
    print_erathos(res, start, end);
}

function init_arr(length){
    var numbers = new Array(length);
    for(var i=0; i<numbers.length; i++){
        numbers[i] = false;
    }
    numbers[0] = true;
    numbers[1] = true;
    return numbers;
}

function print_erathos(arr, start, end){
    for(var i=0; i<arr.length; i++){
        if(arr[i] >= start){
            console.log(arr[i]);
        }
    }
}

solution(11,100);
