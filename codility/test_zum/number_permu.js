function solution(number){
    var string_converted = number.toString();
    var number_size = string_converted.length;
    var zero_cnt = string_converted.split('0').length - 1;

    var denominator = 1; // top
    var numberator = 1; // bottom

    if(zero_cnt > 0){
        denominator = (number_size - zero_cnt) * get_factorial(number_size - 1);
    } else {
        denominator = get_factorial(number_size);
    }

    numberator = duplicate_cases(string_converted);

    return denominator / numberator;
}

function duplicate_cases(number){
    var cnt = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    var num = number.toString();

    for(var i=0; i<num.length; i++){
        cnt[num[i]] += 1;
    }

    var total = 1;

    // 1~10 - 9
    for(var i=0; i<cnt.length; i++){
        if(cnt[i] < 2)
            continue;
        total *= get_factorial(cnt[i]);
    }
    console.log('total', total, 'cnt', cnt, cnt.length);
    
    return total;
}

function get_factorial(number){
    // 0! = 1
    var factorial = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880];
    return factorial[number];
}

console.log(solution(1122));
console.log(solution(1234));
console.log(solution(123400777));
