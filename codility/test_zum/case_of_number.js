function solution(number){

    var string_converted_number = number.toString();
    var length_number = string_converted_number.length;

    var zero_cnt = string_converted_number.split('0').length - 1;

    var bottom, top;

    if(zero_cnt > 0){
        top = factorial(length_number - 1) * (length_number - zero_cnt);
    } else {
        top = factorial(length_number);
    }
    bottom = duplicate(string_converted_number);

    return top/bottom;
}

function duplicate(converted_number){

        //    n, m , 0 .....
    var cnt = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

    for(var i=0; i<converted_number.length ; i++){
        cnt[converted_number[i]] += 1;
    }

    var total = 1;
    for(var i=0; i<cnt.length ; i++){
        if(cnt[i] === 0)
            continue;
        total *= factorial(cnt[i]);
    }

    return total;
}

function factorial(number){
    var factorial = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800];
    return factorial[number];
}

console.log(solution(24491));
