function solution(size, position){

    var stack = [];
    var cnt = 0;
    for(var i=0; i<size.length; i++){

        if(position[i] === 1){
            stack.push(size[i]);
        } else {
            if(stack.length === 0){
                cnt += 1;
            } else {
                if(stack.length >0){
                    while(true){
                        if(stack.slice(-1)[0] < size[i]){
                            console.log('stack', stack, 'size', size[i]);
                            stack.pop();
                        } else{
                            cnt += 1;
                            break;
                        }
                    }
                    console.log('stack', stack);
                } else {
                    cnt += 1;
                }
            }
        }
    }
    console.log('cnt',cnt);
    return cnt + stack.length;
}

// console.log('sol', solution([7,2,4,5,6,3,1], [0,1,0,0,1,0,0]));
console.log('sol', solution([7,2,4,5,6,3,1], [1,1,1,1,0,1,0]));
