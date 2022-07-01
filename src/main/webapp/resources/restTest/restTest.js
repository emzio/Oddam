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

    const button = document.querySelector(".btn-danger");
    console.log("button : ", button);

    button.addEventListener("click", ev => {
        ev.preventDefault();
        getUser(2).then(result => {
            console.log("result: ", result);
            console.log("result.lastname : ", result.lastname);
        }).catch((error) => {
            console.error(error);
        });
    })

})

