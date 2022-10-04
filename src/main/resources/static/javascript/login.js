const loginUsername = document.getElementById(`loginUsername`)
const loginPassword = document.getElementById(`loginPassword`)
const loginForm = document.getElementById(`loginForm`)
const baseUrl = `http://localhost:8080/api/v1/users`

const headers = {
    'Content-Type': 'application/json'
}

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    }


    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
    .catch(err => console.error(err.message))

    const responseArr = await response.json()
    console.log(responseArr)

    if (response.status === 200) {
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace(responseArr[0])
    }
}

loginForm.addEventListener("submit", handleSubmit)
