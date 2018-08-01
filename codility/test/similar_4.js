function solution(num){
    
    var str_number = num.toString();
    var length_num = str_number.length;

    var cnt_zero = str_number.split('0').length - 1;
    console.log(cnt_zero);

    // no same number;
    var total = 1;
    for(var i=0; i<str_number.length; i++){
        if(i === 0 && cnt_zero > 0){
            total *= (length_num - cnt_zero);
        }
    }

}

console.log(solution(123405670));
