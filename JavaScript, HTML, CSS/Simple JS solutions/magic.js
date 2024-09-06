function magic(input) {
    const [mysteriousSpell, ...commands] = input;
    const spell = commands.reduce((currentStateOfSpell, currentCommand) => {
        if (currentCommand === "RemoveEven") {
            const result = currentStateOfSpell.split("").filter((_, index) => index % 2 === 0).join("");
            console.log(result);
            return result;
        }

        if(currentCommand.startsWith("TakePart!")){
            const[,from, to] = currentCommand.split("!");
            const result = currentStateOfSpell.slice(Number(from), Number(to));
            console.log(result);
            return result;
        }

        if(currentCommand.startsWith("Reverse!")){
            const[, substring] = currentCommand.split("!");
            if(!currentStateOfSpell.includes(substring)){  
                console.log("Error");
                return currentStateOfSpell;
            }
            const reversedSpell = substring.split("").reverse().join("");
            const result = currentStateOfSpell.replace(substring, "").concat(reversedSpell);
            console.log(result);
            return result;

        }
        return currentStateOfSpell;

    }, mysteriousSpell)
    console.log("The concealed spell is:",spell);


}
magic(["asAsl2adkda2mdaczsa",
    "RemoveEven",
    "TakePart!1!9",
    "Reverse!maz",
    "End"]);

