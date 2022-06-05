const button = document.querySelector("#button");
const password = document.querySelector("#password");
const passwordRep = document.querySelector("#password2");
let done;
let div = document.createElement("div");

function verifyPasswordRep(event){
    done=false;
    event.preventDefault();
    if(password.value===passwordRep.value){
        div.innerText="Hasła są zgodne, kliknij zmień!";
        console.log("zgodne");
        done=true;
        removePasswordRep(event);
    } else {
        passwordRep.parentElement.appendChild(div);
        div.innerText="Hasła są niezgodne!";
        console.log("niezgodne");
    }

}

function removePasswordRep(event){
    if(done===true){
        console.log("done", done);
        button.removeEventListener("click", verifyPasswordRep);
        // console.log(event.target);
        // event.target.trigger("click");
    }
}

button.addEventListener("click", verifyPasswordRep);

