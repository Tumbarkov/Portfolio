function bar(input){
    const baristaCount = Number(input.shift());
    const team = {};
    for (let i = 0; i < baristaCount; i++) {
        const [name, shift , coffeeTypes] = input[i].split(' ');

        team[name] = {
            shift,
            coffeeTypes: coffeeTypes.split(','),
        }
    }

    let commandLine = input.shift();

    while(commandLine != 'Closed'){
        const [command, name, firstArg, secondArg] = commandLine.split(' / ');
        const barista = team[name];
    
        let shift, coffeeType;
        switch(command){
            case 'Prepare':
                shift = firstArg;
                coffeeType = secondArg;
                if(barista.shift === shift && barista.coffeeTypes.includes(coffeeType)){
                    console.log(`${name} has prepared a ${coffeeType} for you!`)
                }else{
                    console.log(`${name} is not available to prepare a ${coffeeType}.`);
                }
                break;
            case 'Change Shift':
                shift = firstArg;
                barista.shift = shift
                console.log(`${name} has updated his shift to: ${shift}`);

                break;
            case 'Learn':
                newCoffee = firstArg;
                if(barista.coffeeTypes.includes(newCoffee)){
                    console.log(`${name} knows how to make ${newCoffee}.`);                  
                }else{
                    barista.coffeeTypes.push(newCoffee);
                    console.log(`${name} has learned a new coffee type: ${newCoffee}.`);
                }
                break;
                
        }
        commandLine = input.shift();
    }
    
    Object.keys(team)
        .forEach(name =>{
            const { shift, coffeeTypes } = team[name];
            console.log(`Barista: ${name}, Shift: ${shift}, Drinks: ${coffeeTypes.join(", ")} `); //how to be at one line .join() is for spacing
        })

}
bar(['3',
      'Alice day Espresso,Cappuccino',
      'Bob night Latte,Mocha',
      'Carol day Americano,Mocha',
      'Prepare / Alice / day / Espresso',
      'Change Shift / Bob / night',
      'Learn / Carol / Latte',
      'Learn / Bob / Latte',
      'Prepare / Bob / night / Latte',
      'Closed']);
 