window.addEventListener("load", solve);
function solve(){
    const addButonElement = document.getElementById('add-btn');
    const previewListElement = document.getElementById('preview-list'); //specified in the doc
    const expenseList= document.getElementById('expenses-list');
    const deleteButtonElement = document.querySelector('.btn.delete'); //if the specified field has just space 
    
    const expenseInputElement = document.getElementById('expense');
    const amountInputElement = document.getElementById('amount');
    const dateInputElement = document.getElementById('date');
    
    addButonElement.addEventListener('click', () => {

      //get input data
      const expense = expenseInputElement.value;
      const amount = amountInputElement.value;
      const date = dateInputElement.value;

      // //check empty element
      // if(!expense || !amount || !date){
      //   return;
      // }

        //create checklist/article/etc. element
        const expenseLiElement = createArticleElement(expense, amount, date);

        //add element to checklist/article/etc.
        previewListElement.appendChild(expenseLiElement);

        //disable add button
        addButonElement.setAttribute('disabled', 'disabled');

        //clear inputs
        clearInputs();
      
    });

    deleteButtonElement.addEventListener('click', () =>{
      expenseList.innerHTML = '';
    });

    //clear inputs func
    function clearInputs() {
      expenseInputElement.value = '';
      amountInputElement.value = '';
      dateInputElement.value = '';
    }
    
    function createArticleElement(expense, amount, date){
      const pExpenseElement = document.createElement('p');
      pExpenseElement.textContent = `Type: ${expense}`; //important to make a space between Type and expense
      
      const pAmountElement = document.createElement('p');
      pAmountElement.textContent = `Amount: ${amount}$`; //FOR NUMBERS IF SHOULD BE WITH A SECOND AT THE BACK $ !!!!!!!!!!!!111
      
      const pDateElement = document.createElement('p');
      pDateElement.textContent = `Date: ${date}`;

      const articleElement = document.createElement('article');
      articleElement.appendChild(pExpenseElement);
      articleElement.appendChild(pAmountElement);
      articleElement.appendChild(pDateElement);

      const editButton = document.createElement('button');
      //editButton.classList.add('btn edit'); dont use if the file specifes spaces between words not "-"
      editButton.classList.add('btn', 'edit'); //correct way 
      editButton.textContent = "edit"; //if there is text for the button 

      const okButton = document.createElement('button');
      okButton.classList.add('btn', 'ok');
      okButton.textContent= "ok"; //if there is text for the button 

      const divButtons = document.createElement('div');// div should be changed if specified
      divButtons.classList.add('buttons');
      divButtons.appendChild(editButton);
      divButtons.appendChild(okButton);

      const liExpenseElement = document.createElement('li');
      liExpenseElement.classList.add('expense-item'); //this is only if specified
      liExpenseElement.appendChild(articleElement);
      liExpenseElement.appendChild(divButtons);

      editButton.addEventListener('click', () => {

        // set inputs
        expenseInputElement.value = expense;
        amountInputElement.value = amount;
        dateInputElement.value = date;

        //activate add button
        addButonElement.removeAttribute('disabled');

        //remove checklist element
        liExpenseElement.remove();
      });
      okButton.addEventListener('click', () => {
        //remove edit and save buttons
        divButtons.remove();

        //enable add button
        addButonElement.removeAttribute('disabled');

        //move to expense list
        expenseList.appendChild(liExpenseElement);

      });

      return liExpenseElement;
    }
  }
