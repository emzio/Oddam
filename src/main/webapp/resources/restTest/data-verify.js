
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
            checkEmailAvailability();
        }

        console.log("messagesArrAfterEmailCheck", messagesArr);

        if (messagesArr.length === 0) {
            done = true;
            console.log("trigger on");
            $(this).trigger("click");
        }
    }

    function checkPassRepetition() {
        if (password.value !== passwordRep.value) {
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
        console.log("email patter", pattern);
        if (!email.value.match(pattern) ) {
            createMessage("Wpisz email", email, "#emailEmpty");
        }
    }

    function checkEmailAvailability() {
        checkEmailJson(email, id).then(result => {
        if (!result) {
            createMessage("Ten adres email nie jest dostępny.", email, "#emailMessage");
        }
    });
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
                return resp;
            }
        )
    }

    function createMessage(text, element, id) {
        let messageEl = document.getElementById(id);
        if (messageEl === null) {
            let div = document.createElement("div");
            div.id = id;
            div.classList.add("alert-form");
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

// document.addEventListener("DOMContentLoaded",function (e) {
//
//     let done = false;
//     const password = document.querySelector("#password");
//     const passwordRep = document.querySelector("#password2");
//     const submit = document.querySelector(".btn[type=submit]");
//     const email = document.querySelector("#username");
//     const id = document.querySelector("#id");
//     let messagesArr = [];
//
//     function getApiHost(email, id) {
//         if (id === null) {
//             return 'http://localhost:8080/check/email/' + email.value;
//         } else {
//             return 'http://localhost:8080/check/email/' + email.value + '/?id=' + id.value;
//         }
//     }
//
//     function dataCheckingEvent(event) {
//         if (done === true) {
//             done = false;
//             return;
//         }
//         event.preventDefault();
//         console.log("messagesArr before clearing", messagesArr);
//
//         clear();
//         console.log("messagesArr AFTER clearing", messagesArr);
//         checkPassRepetition();
//         checkPassFormat();
//         checkEmailFormat();
//
//         console.log("messagesArr", messagesArr);
//
//         if (messagesArr.length === 0) {
//             checkEmailAvailability();
//         }
//
//         console.log("messagesArrAfterEmailCheck", messagesArr);
//
//         if (messagesArr.length === 0) {
//             done = true;
//             console.log("trigger on");
//             $(this).trigger("click");
//         }
//     }
//
//     function checkPassRepetition() {
//         if (password.value !== passwordRep.value) {
//             createMessage("Hasła są niezgodne!", password, "#passwordMessage");
//         }
//     }
//
//     function checkPassFormat(){
//         const pattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
//         if(!password.value.match(pattern)){
//             createMessage("Hasło musi zawierać małe i duże znaki, znak specjalny i cyfrę i mieć co najmniej 8 znaków", password, "#passFormatMess");
//         }
//     }
//
//     function checkEmailFormat() {
//         if (email.value === "") {
//             createMessage("Wpisz email", email, "#emailEmpty");
//         }
//     }
//
//     function checkEmailAvailability() {
//         checkEmailJson(email, id).then(result => {
//             //     if (result) {
//             //         deleteMessage(email, "#emailMessage");
//             //     } else {
//             //         createMessage("Ten adres email nie jest dostępny.", email, "#emailMessage");
//             //     }
//             // });
//             if (!result) {
//                 createMessage("Ten adres email nie jest dostępny.", email, "#emailMessage");
//             }
//         });
//     }
//
//     function checkEmailJson(email, id) {
//         return fetch(getApiHost(email, id),
//             {}
//         ).then(
//             function (resp) {
//                 if (!resp.ok) {
//                     alert('Wystąpił błąd!');
//                     return resp.status;
//                 }
//                 return resp;
//             }
//         )
//     }
//
//     function createMessage(text, element, id) {
//         let messageEl = document.getElementById(id);
//         if (messageEl === null) {
//             let div = document.createElement("div");
//             div.id = id;
//             div.classList.add("alert-form");
//             div.innerText = text;
//             element.parentElement.appendChild(div);
//             messagesArr.push(div);
//         }
//     }
//
//     function deleteMessage(element, id) {
//         let messageEl = document.getElementById(id);
//         if (messageEl) {
//             messageEl.remove();
//         }
//     }
//
//     // function clear(messageArr){
//     //     for (let i = 0; i < messageArr.length; i++) {
//     //         messageArr[i].remove();
//     //         messageArr.splice(i, 1);
//     //     }
//     // }
//     function clear(){
//         for (let i = 0; i < messagesArr.length; i++) {
//             messagesArr[i].remove();
//         }
//         messagesArr=[];
//     }
//
//
//
//     submit.addEventListener("click", dataCheckingEvent);
//
// })



