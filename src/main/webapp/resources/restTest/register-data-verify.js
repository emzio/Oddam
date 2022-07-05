
document.addEventListener("DOMContentLoaded",function (e){

    let done = false;
    const password = document.querySelector("#password");
    const passwordRep = document.querySelector("#password2");
    const submit = document.querySelector(".btn[type=submit]");
    const email = document.querySelector("#email");
    const id = document.querySelector("#id");
    console.log(submit, email, id, password, passwordRep);

    function getApiHost(email, id){
        if(id===null){
            return 'http://localhost:8080/check/email/'+ email.value;
        } else {
            return 'http://localhost:8080/check/email/'+ email.value + '/?id=' + id.value;
        }
    }

    function dataCheckingEvent(event){
        if(done===true){
            done=false;
            return;
        }
        event.preventDefault();
        if(passwordRepAccepted()){
            checkEmailJson(email, id).then(result => {
                console.log("emailChecking result: " , result)
                if(result){
                    done = true;
                    console.log("trigger on");
                    deletingEmailWarning();
                    $(this).trigger("click");
                } else {
                    console.log("event still working");
                    creatingEmailWarning();
                }
            });
        } else {
            console.log("Hasło błąd");
        }

    }

    function passwordRepAccepted(){
        if(password.value===passwordRep.value){
            let div = document.querySelector("#passwordMessage");
            if(div){
                div.remove();
            }
            return true;
        } else {
            if(!document.querySelector("#passwordMessage")){
                let div = document.createElement("div");
                passwordRep.parentElement.appendChild(div);
                div.id= "passwordMessage";
                div.classList.add("alert-form");
                div.innerText="Hasła są niezgodne!";
                console.log("niezgodne");
            }
            return false;
        }
    }

    function checkEmailJson(email, id) {
        return fetch(getApiHost(email, id),
            {
            }
        ).then(
            function(resp) {
                if(!resp.ok) {
                    alert('Wystąpił błąd!');
                    console.log("resp.status : ", resp.status);
                    return resp.status;
                }
                let ret = resp.json();
                console.log("return: ", ret);
                return ret;
            }
        )
    }

    function creatingEmailWarning(){
        if (email.parentElement.querySelector("#emailMessage")===null){
            const div = document.createElement("div");
            div.id="emailMessage";
            div.classList.add("alert-form");
            div.innerText = "Ten adres email nie jest dostępny.";
            email.parentElement.appendChild(div);
        }

    }

    function  deletingEmailWarning(){
        let div = email.parentElement.querySelector("#emailMessage");
        if (div){
            div.remove();
        }
    }

    submit.addEventListener("click", dataCheckingEvent);

})
