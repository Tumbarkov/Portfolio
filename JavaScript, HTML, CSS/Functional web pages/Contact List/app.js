window.addEventListener("load", solve);

function solve() {
  
    const addButon = document.getElementById('add-btn');
    const checkList = document.getElementById('check-list');
    const contactList= document.getElementById('contact-list');
    
    const nameInput = document.getElementById('name');
    const phoneInput = document.getElementById('phone');
    const categoryInput = document.getElementById('category');
    
    addButon.addEventListener('click', () => {
      //get input data
      const name = nameInput.value;
      const phone = phoneInput.value;
      const category = categoryInput.value;

      //create checklist element
      const liElement = createCheckListElement(name, phone, category);

      //add element to checklist
      checkList.appendChild(liElement);

      //clear inputs
      clearInputs();
      
    });
    //clear inputs func
    function clearInputs() {
      nameInput.value = '';
      phoneInput.value = '';
      categoryInput.value = '';
    }
    
    function createCheckListElement(name, phoneNumber, category){
      const pNameElement = document.createElement('p');
      pNameElement.textContent = `name:${name}`;
      
      const pPhoneElement = document.createElement('p');
      pPhoneElement.textContent = `phone:${phoneNumber}`;
      
      const pCategoryElement = document.createElement('p');
      pCategoryElement.textContent = `category:${category}`;

      const articleElement = document.createElement('article');
      articleElement.appendChild(pNameElement);
      articleElement.appendChild(pPhoneElement);
      articleElement.appendChild(pCategoryElement);

      const editButton = document.createElement('button');
      editButton.classList.add('edit-btn');

      const saveButton = document.createElement('button');
      saveButton.classList.add('save-btn');

      const divButtons = document.createElement('div');
      divButtons.classList.add('buttons');
      divButtons.appendChild(editButton);
      divButtons.appendChild(saveButton);

      const liElement = document.createElement('li');
      liElement.appendChild(articleElement);
      liElement.appendChild(divButtons);

      editButton.addEventListener('click', () => {
        // set inputs
        nameInput.value = name;
        phoneInput.value = phoneNumber;
        categoryInput.value = category;

        //remove checklist element
        liElement.remove();
      });
      saveButton.addEventListener('click', () => {
        //remove edit and save buttons
        divButtons.remove();

        //create delete button
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('del-btn');

        deleteButton.addEventListener('click', () => {
          liElement.remove();
        });

        //add delete button
        liElement.appendChild(deleteButton);

        //move to contact list
        contactList.appendChild(liElement);

        //remove li element from checklist is done when we append to contact list
      });

      return liElement;
    }
  }
  