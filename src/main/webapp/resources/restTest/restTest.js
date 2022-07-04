document.addEventListener("DOMContentLoaded",function (e){

    function getUser(Id) {
        return fetch(
            'http://localhost:8080/rest/' + Id,
            {

            }
        ).then(
            function(resp) {
                if(!resp.ok) {
                    alert('Wystąpił błąd! Otwórz devtools i zakładkę Sieć/Network, i poszukaj przyczyny');
                    console.log("resp.status : ", resp.status);
                    return resp.status;
                }
                const ret = resp.json();
                console.log(ret);
                return ret;
            }
        );
    }

    function checkEmail(email, id) {
        return fetch(
            'http://localhost:8080/check/email/'+ email + '/?id=' + id,
            {

            }
        ).then(
            function(resp) {
                if(!resp.ok) {
                    alert('Wystąpił błąd! Otwórz devtools i zakładkę Sieć/Network, i poszukaj przyczyny');
                    console.log("resp.status : ", resp.status);
                    return resp.status;
                }
                const ret = resp.json();
                console.log(ret);
                return ret;
            }
        );
    }

    const button = document.querySelector(".btn-danger");
    const submit = document.querySelector("#submit");
    const email = document.querySelector("#email");
    const id = document.querySelector("#id");

    console.log("button : ", button);
    console.log("submit: ", submit);
    console.log("email: ", email);
    console.log("id: ", id);


    button.addEventListener("click", ev => {
        ev.preventDefault();
        getUser(3).then(result => {
            console.log("result: ", result);
            console.log("result.lastname : ", result.lastname);
        }).catch((error) => {
            console.error(error);
        });
    })
    submit.addEventListener("click", e => {
        e.preventDefault();
        checkEmail(email.value, id.value).then(result => {
            console.log("email.value: ", email.value)
            console.log("email result: " , result)
        }).catch((error) => {
            console.log(error);
        });
    })


})

