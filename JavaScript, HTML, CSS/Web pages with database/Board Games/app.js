const baseUrl = `http://localhost:3030/jsonstore/games`;
//Get load button element
const loadButton = document.getElementById('load-games');
const addButton = document.getElementById('add-game');
const editButton = document.getElementById('edit-game');
const gamesList = document.getElementById('games-list');
//This is how we get ID of every game
const formElement = document.querySelector('#form form');

const nameInput = document.getElementById('g-name'); //input data from fields
const typeInput = document.getElementById('type'); //input data from fields
const playersInput = document.getElementById('players'); //input data from fields
// Load games
loadButton.addEventListener('click', () =>{
    loadGames();
});
addButton.addEventListener('click', () =>{
    addGame();
});
editButton.addEventListener('click', () =>{
    editGame();
});
async function addGame() {

    //Get input data
    const name = nameInput.value;
    const type = typeInput.value;
    const players = playersInput.value;

    //clear all inputs
    clearInputs();

    //Create POST request
    const response = await fetch(baseUrl,{
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({name, type, players}),
    });

    //fetch all games
    await loadGames();


    
}

async function editGame(){
    //Get Id from attribute
    const gameId = formElement.getAttribute('data-game-id');

    // Get info from inputs
    const name = nameInput.value;
    const type = typeInput.value;
    const players = playersInput.value;

    // Clear inputs
    clearInputs();

    // Send Put request 
    await fetch(`${baseUrl}/${gameId}`,{
        method: 'PUT',
        headers:{
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({name, type, players, _id: gameId}),
    });

    // Load all games
    await loadGames();

    // Deactivate edit button
    editButton.setAttribute('disabled', 'disabled')

    // Activate add button
    addButton.removeAttribute('disabled');

    // Clear attribute Id
    formElement.removeAttribute('data-game-id');
}

async function loadGames() {
    // Clear games list
    gamesList.innerHTML = '';

    // Get request
    const response = await fetch(baseUrl);
    const result = await response.json();
    const games = Object.values(result);
    
    // Create game element
    const gameElements = games.map(game => createGameElement(game.name, game.type, game.players, game._id));
   
    // Add to game list
    gamesList.append(...gameElements);
    // Edit button deactivated  
}

function createGameElement(name, type, players, gameId){
    const pNameElement = document.createElement('p');
    pNameElement.textContent = name;

    const pTypeElement = document.createElement('p');
    pTypeElement.textContent = type;

    const pMaxPlayersElement = document.createElement('p');
    pMaxPlayersElement.textContent = players;

    const divContentElement = document.createElement('div');
    divContentElement.classList.add('content');
    divContentElement.appendChild(pNameElement);
    divContentElement.appendChild(pTypeElement);
    divContentElement.appendChild(pMaxPlayersElement);

    const changeButton = document.createElement('button');
    changeButton.classList.add('change-btn');
    changeButton.textContent='Change';
    changeButton.addEventListener('click', () =>{

        // Populate game info into input fields
        nameInput.value = name;
        typeInput.value = type;
        playersInput.value = players;

        // Activate edit game button 
        editButton.removeAttribute('disabled');

        // Add game should be deactivated
        addButton.setAttribute('disabled', 'disabled');

        // Set id attribute
        formElement.setAttribute('data-game-id', gameId);


    });

    const deleteButton = document.createElement('button');
    deleteButton.classList.add('delete-btn');
    deleteButton.textContent='Delete';
    deleteButton.addEventListener('click', async () =>{
        // Send Delete request
        await fetch(`${baseUrl}/${gameId}`,{
            method:`DELETE`,
        });
        // Fetch all games
        await loadGames();
    });

    const divButtons = document.createElement('div');
    divButtons.classList.add(`buttons-container`);
    divButtons.appendChild(changeButton);
    divButtons.appendChild(deleteButton);

    const gameDivElement = document.createElement('div');
    gameDivElement.classList.add('board-game');
    gameDivElement.appendChild(divContentElement);
    gameDivElement.appendChild(divButtons);

    return gameDivElement;

}

function clearInputs(){
    nameInput.value = ''; 
    typeInput.value = '';
    playersInput.value = '';

}

