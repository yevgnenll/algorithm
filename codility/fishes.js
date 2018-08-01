function solution(size, position){

    if(size.length === 1)
        return 1;
    var after_fight = fight_fishes(size, position);
    return after_fight;
}

function fight_fishes(size, position){
    var war = [{'s':size[0], 'p':position[0]}];
    for(var i=1; i<size.length; i++){
        var stat = war[war.length-1];
        if(position[i] === 0){

            if(stat['p'] === 1 && stat['s'] < size[i]){
                war.pop();
                war.push({'p':position[i], 's':size[i]});
            }
        } else {
            while(true){
                var stat = war[war.length-1];
                if(stat['p'] === 1){
                    war.push({'p':position[i], 's':size[i]});    
                    break;
                } else {
                    if(stat.s < size[i]){
                        war.pop();
                    }
                }
                war.push({'p':position[i], 's':size[i]});
            }
            
        }
        console.log('war', war);
    }

    return war.length;
}

/*
console.log('sol', solution([4,0,2,1,5], [0,1,0,0,0]));
console.log('sol', solution([4,3,2,1,5], [0,1,0,0,0]));
console.log('sol', solution([7,2,4,5,6,3,1], [0,1,0,0,1,0]));
console.log('sol', solution([7,2,4,5,6,3,1], [1,1,1,1,1,0]));
console.log('sol', solution([4,3,2,1,5], [1,0,1,1,1]));
console.log('sol', solution([4,0,2,1,5], [0,1,0,0,0]));
*/

console.log('sol', solution([7,2,4,5,6,3,1], [0,1,0,0,1,0,0]));
console.log('sol', solution([7,2,4,5,6,3,1], [1,1,1,1,0,1,0]));
