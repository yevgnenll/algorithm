function solution(num){

    if(num<10){ return 1;}
    var str_num = num.toString();
    var num_length = str_num.length;
    var zero_cnt = str_num.split('0').length -1 ;

    var top = 1;
    var bottom = 1;
    if(zero_cnt > 0){
        top = permutation(num_length - 1) * (num_length - zero_cnt);
    } else {
        top = permutation(str_num.length);
    }
    bottom = duplicate_permutation(str_num);
    return top/bottom;

}

function duplicate_permutation(num_string){

    var data = {};
    for(var i=0; i<num_string.length; i++){
        if(!data[num_string[i]]){
            data[num_string[i]] = 1;
        } else {
            data[num_string[i]] += 1;
        }
    }

    // no duplicated number
    if(num_string.length === Object.keys(data).length){
        return 1;
    }

    var total = 1;
    for(var key in data){ 
        total *= permutation(data[key]);
    };
    return total;
}

function permutation(n){
    if(n === 1) return 1;
    var total = 1;
    for(var i=n; i>0; i--){
        total *= i;
    }
    return total;
}

console.log(solution(9999));
console.log(solution(1234));
