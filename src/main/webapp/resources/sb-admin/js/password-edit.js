const button = document.querySelector("#button");
const password = document.querySelector("#password");
const passwordRep = document.querySelector("#password2");
let done = false;
const pattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
let messagesArr = [];



function createMessage(text) {
    let messageEl = document.getElementById(id);
    if (messageEl === null) {
        let div = document.createElement("div");
        div.classList.add("alert-warning");
        div.classList.add("alert-form");
        div.innerText = text;
        password.parentElement.appendChild(div);
        messagesArr.push(div);
    }
}

function clearMessages(){
    for (let i = 0; i < messagesArr.length; i++) {
        messagesArr[i].remove();
    }
    messagesArr=[];
}

function verifyPassword(event){
    if(done===true){
        done=false;
        return;
    }
    event.preventDefault();
    clearMessages();
    console.log(password.value, passwordRep.value);
    if(password.value!==passwordRep.value){
        console.log("Hasła są niezgodne!");
        createMessage("Hasła są niezgodne!");
    }
    if(!password.value.match(pattern)){
        createMessage("Hasło musi zawierać małe i duże znaki, znak specjalny i cyfrę i mieć co najmniej 8 znaków");
    }
    console.log("messagesArr",messagesArr)
    if(messagesArr.length===0) {
        done = true;
        $(this).trigger("click");
    }
}


button.addEventListener("click", verifyPassword);

