Array.prototype.max = function(){
    return Math.max.apply(null, this);
}


function solution(arr){
    var max = arr.max();
    var total = 0;
    if(arr.length > 1000000000){return -1;}
    for(var y=0; y<max; y++){
        var block = [];
        
        for(var i=0; i<arr.length; i++){
            if(arr[i] > 0){
                arr[i] -=1;
                block.push(1);
            } else {
                block.push(0);
            }
            
        }
        total += count_block(block);
    }

    return total;
}

function count_block(block){
    var cnt = 0;
    for(var i=0; i<block.length; i++){
        if(i === 0 && block[i] === 1){
            cnt += 1;
        }
        if(block[i] === 0 && block[i+1] === 1){
            cnt += 1;
        }
    }

    return cnt;
}


