const button = document.querySelector("#submitBtn");
const password = document.querySelector("#password");
const passwordRep = document.querySelector("#password2");
let done=false;
let div = document.createElement("div");

console.log(button);

function verifyPasswordRep(event){
    if(done===true){
        done=false;
        return;
    }
    event.preventDefault();
    if(password.value===passwordRep.value){
        done=true;
        // debugger;
        console.log("this", this);
        console.log("event.target",event.target);
        $(this).trigger("click");
    } else {
        passwordRep.parentElement.appendChild(div);
        div.innerText="Hasła są niezgodne!";
        console.log("niezgodne");
    }

}


button.addEventListener("click", verifyPasswordRep);