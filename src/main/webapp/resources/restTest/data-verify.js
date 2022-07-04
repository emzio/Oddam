
document.addEventListener("DOMContentLoaded",function (e){

    let done = false;
    // const submit = document.querySelector("#submit");
    const submit = document.querySelector(".btn[type=submit]");
    const email = document.querySelector("#email");
    const id = document.querySelector("#id");

    function dataCheckingEvent(event){
        if(done===true){
            done=false;
            return;
        }
        event.preventDefault();
        checkEmailJson(email.value, id.value).then(result => {
            console.log("emailChecking result: " , result)
            if(result){
                done = true;
                console.log("trigger on");
                $(this).trigger("click");
            } else {
                console.log("event still working");
                creatingEmailWarning();
            }
        });
    }

    function checkEmailJson(email, id) {
        return fetch(
            'http://localhost:8080/check/email/'+ email + '/?id=' + id,
            {

            }
        ).then(
            function(resp) {
                if(!resp.ok) {
                    alert('Wystąpił błąd!');
                    console.log("resp.status : ", resp.status);
                    return resp.status;
                }
                const ret = resp.json();
                console.log("return: ", ret);
                return ret;
            }
        )
    }

    function creatingEmailWarning(){
        const div = document.createElement("div");
        div.classList.add("alert-warning");
        div.innerText = "Ten adres email nie jest dostępny.";
        email.parentElement.appendChild(div);
    }



    submit.addEventListener("click", dataCheckingEvent);

})





