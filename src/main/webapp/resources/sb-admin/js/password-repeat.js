const button = document.querySelector(".form-group .btn");
const password = document.querySelector("#password");
const passwordRep = document.querySelector("#password2");
let done;


function verifyPasswordRep(event){
    done=false;
    event.preventDefault();
    if(password.value===passwordRep.value){
        console.log("zgodne");
        done=true;
    } else {
        let div = document.createElement("div");
        passwordRep.parentElement.appendChild(div);
        div.innerText="Hasła są niezgodne!"
        console.log("niezgodne");
    }
    removePasswordRep(event);
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

