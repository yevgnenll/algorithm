
function solution(N) {
    check_binary = dec_to_bin(N);

    console.log('check', check_binary);
    var splited_binary = check_binary.split('1');
    var max_depth = 0;

    console.log(splited_binary);
    for(var i=0; i<splited_binary.length ; i++){
        if(splited_binary[i].indexOf('0') > -1){
            var depth = splited_binary[i].length;
            if(max_depth < depth && splited_binary.length-1 > i){
                max_depth = depth;
            }
        }
    }

    return max_depth;
}

function dec_to_bin(dec){
    return (dec >>> 0).toString(2);
}

console.log(solution(20));
