Array.prototype.min = function() {
      return Math.min.apply(null, this);
};

function solution(nucleo, start, end) {
    convert_nucleo = get_nucleo_number(nucleo);
    var result = [];
    if(nucleo.length === 1){
        count = Math.min(start.length, end.length);
        for(var i=0; i<count; i++){
            result.push(get_nucleo_number(convert_nucleo[0]));
            return result;
        }
    }
    var check_nucleo = '';
    for(var i=0; i<start.length; i++){
        check_nucleo = convert_nucleo.slice(start[i], end[i]+1);
        result.push(get_minimal(check_nucleo));
    }

    return result;
}

function get_nucleo_number(string){
    var data = {'A':'1', 'C':'2', 'G':'3', 'T':'4'};
    var res = '';
    for(var i=0; i<string.length; i++){
        res += data[string[i]];
    }
    
    return res;
}

function get_minimal(divided_nucleo){

    if(divided_nucleo.length === 1)
        return parseInt(divided_nucleo[0]);

    var min = 10;
    for(var i=0; i<divided_nucleo.length; i++){

        convert = parseInt(divided_nucleo[i]);
        if (min > convert){
            min = convert;
        }
    }

    return min;
}

p = [2, 5, 0];
q = [4, 5, 6];
s = 'CAGCCTA';
s1 = 'C'
console.log(solution(s, p, q));
