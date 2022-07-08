
document.addEventListener("DOMContentLoaded",function (e) {

    let done = false;
    const password = document.querySelector("#password");
    const passwordRep = document.querySelector("#password2");
    const submit = document.querySelector(".btn[type=submit]");
    const email = document.querySelector("#username");
    const id = document.querySelector("#id");
    let messagesArr = [];

    function getApiHost(email, id) {
        if (id === null) {
            return 'http://localhost:8080/check/email/' + email.value;
        } else {
            return 'http://localhost:8080/check/email/' + email.value + '/?id=' + id.value;
        }
    }

    function dataCheckingEvent(event) {
        if (done === true) {
            done = false;
            return;
        }
        event.preventDefault();
        console.log("messagesArr before clearing", messagesArr);

        clear();
        console.log("messagesArr AFTER clearing", messagesArr);
        checkPassRepetition();
        checkPassFormat();
        checkEmailFormat();

        console.log("messagesArr", messagesArr);

        if (messagesArr.length === 0) {
            checkEmailJson(email, id).then(result => {
                if(!result){
                    createMessage("Ten adres email nie jest dostępny.", email, "#emailMessage");
                } else {
                    done = true;
                    console.log("trigger on");
                    $(this).trigger("click");
                }
            })
        }
    }

    function checkPassRepetition() {
        if (passwordRep && password.value !== passwordRep.value) {
            createMessage("Hasła są niezgodne!", password, "#passwordMessage");
        }
    }

    function checkPassFormat(){
        const pattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
        if(!password.value.match(pattern)){
            createMessage("Hasło musi zawierać małe i duże znaki, znak specjalny i cyfrę i mieć co najmniej 8 znaków", password, "#passFormatMess");
        }
    }


    function checkEmailFormat() {
        const pattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
        if (!email.value.match(pattern) ) {
            createMessage("Wpisz email", email, "#emailEmpty");
        }
    }

    function checkEmailJson(email, id) {
        return fetch(getApiHost(email, id),
            {}
        ).then(
            function (resp) {
                if (!resp.ok) {
                    alert('Wystąpił błąd!');
                    return resp.status;
                }
                let ret = resp;
                console.log("ret", ret);
                return ret.json();
            }
        )
    }

    function createMessage(text, element, id) {
        let messageEl = document.getElementById(id);
        if (messageEl === null) {
            let div = document.createElement("div");
            div.id = id;
            div.classList.add("alert-form");
            div.classList.add("alert-warning");
            div.innerText = text;
            element.parentElement.appendChild(div);
            messagesArr.push(div);
        }
    }

    function clear(){
        for (let i = 0; i < messagesArr.length; i++) {
                    messagesArr[i].remove();
                }
        messagesArr=[];
    }

    submit.addEventListener("click", dataCheckingEvent);
})
