const registerForm = document.getElementById(`registerForm`)
const registerName = document.getElementById(`registerName`)
const registerUsername = document.getElementById(`registerUsername`)
const registerPassword = document.getElementById(`registerPassword`)
const confirmPassword = document.getElementById(`confirmPassword`)

const headers = {
    'Content Type': 'application.json'
}

const baseUrl = `http://localhost:8080/api/v1/users`

const handleSubmit = async (e) => {
    e.preventDefault
    

    if (registerName.value === '' || registerUsername.value === '' || registerPassword.value === '') {
        alert(`Please fill out all fields.`)
    }
    else if(registerPassword.value != confirmPassword.value) {
        alert('Passowrds do not match.')
    }

    else{

        let bodyObj = {
            name: registerName.value,
            username: registerUsername.value,
            password: registerPassword.value
        }
        console.log(bodyObj)

        const response = await fetch(`${baseUrl}/register`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: headers
        })
        .catch(err => console.error(err.message))

        const responseArr = await response.json()

        if (response.status === 200) {
            window.location.replace(responseArr[0])
        }
    }
}

registerForm.addEventListener("submit", handleSubmit())