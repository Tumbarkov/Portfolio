function adventure(input){
    const charactersCount = Number(input.shift());
    const posse = {};
    for (let i = 0; i < charactersCount; i++) {
        const [characterName, hpInput , bulletsInput] = input.shift().split(' ');

        posse[characterName] = {
            hp: Number(hpInput),
            bullets: Number(bulletsInput),
        };

        
    }
    const commands = {
        FireShot(characterName, target){
            if(posse[characterName].bullets){
                const currentBullets= --posse[characterName].bullets;
                console.log(`${characterName} has successfully hit ${target} and now has ${currentBullets} bullets`);
            }else{
                console.log(`${characterName} doesn't have enough bullets to shoot at ${target}!`);
            }

        },
        TakeHit(characterName, damage, attacker){
            damage= Number(damage);
            posse[characterName].hp -= damage;
            const currentHp = posse[characterName].hp;
            
            if(currentHp > 0){
                console.log(`${characterName} took a hit for ${damage} HP from ${attacker} and now has ${currentHp} HP!`);
            }else{
                console.log(`${characterName} was gunned down by ${attacker}!`);
                delete posse[characterName];
            }
        },
        Reload(characterName){
            const current= posse[characterName].bullets;
            if(current < 6){
                posse[characterName].bullets = 6;
                console.log(`${characterName} reloaded ${6- current} bullets!`);
            }else{
                console.log(`${characterName}'s pistol is fully loaded!`);
            }

        },
        PatchUp(characterName, amount){
            amount = Number(amount);
            const currentHp = posse[characterName].hp;
            if(currentHp < 100){
                const newHp = Math.min(currentHp + amount, 100);
                posse[characterName].hp = newHp;
                const recoveredAmount = newHp - currentHp;
                console.log(`${characterName} patched up and recovered ${recoveredAmount} HP!`);
            } else{
                console.log(`${characterName} is in full health!`);
            }
            
        }
    };

    let commandInput = input.shift();

    while (commandInput !== `Ride Off Into Sunset`) {
        const [command, characterName, ...args] = commandInput.split(" - ");
        commands[command](characterName, ...args);
        commandInput = input.shift();
    }
    Object.keys(posse)
        .forEach(characterName =>{
            console.log(characterName);
            console.log(`HP: ${posse[characterName].hp}`);
            console.log(`Bullets: ${posse[characterName].bullets}`);
        })

}
adventure(["2",
    "Gus 100 4",
    "Walt 100 5",
    "FireShot - Gus - Bandit",
    "TakeHit - Walt - 100 - Bandit",
    "Reload - Gus",
    "Ride Off Into Sunset"]);
 