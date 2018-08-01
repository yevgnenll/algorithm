function solution(str){
    var open = '({[';
    var close = ')}]';
    var pair = {')': '(', '}': '{', ']':'['};
    var bracket = [];

    for(var i=str.length-1; i>=0; i--){
        if(open.indexOf(str[i]) > -1){
            if(bracket[bracket.length-1] === str[i]){
                bracket.pop();
            } else {
                return 0;
            }
        }
        if(close.indexOf(str[i]) > -1){
            bracket.push(pair[str[i]]);
        }
    }
    
    if(bracket.length === 0)
        return 1;
    else
        return 0;
}

console.log(solution('(((()(()()))(())()))(()())'));
