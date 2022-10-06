const cookieArr = document.cookie.split(`=`)
const userId = cookieArr[1]

const newWorkoutForm = document.getElementById(`newWorkout`)
const newWorkoutName = document.getElementById("newWorkoutName")
const newWorkoutBtn = document.getElementById("newWorkoutBtn")
const workoutContainer = document.getElementById(`workoutContainer`)
const workoutSelect = document.getElementById(`workoutSelect`)
const addExerciseButton = document.getElementById(`addExerciseButton`)
const addExerciseName = document.getElementById(`addExerciseName`)
const addExerciseSets = document.getElementById(`addExerciseSets`)
const addExerciseReps = document.getElementById(`addExerciseReps`)
const addExerciseWeight = document.getElementById(`addExerciseWeight`)
const addExerciseDistance = document.getElementById(`addExerciseDistance`)
const addExerciseDuration = document.getElementById(`addExerciseDuration`)
const addExerciseSpeed = document.getElementById(`addExerciseSpeed`)


const headers = {
    'Content-Type': 'application/json'
}

const baseUserUrl = "http://localhost:8080/api/v1/users"
const baseWorkoutUrl = "http://localhost:8080/api/v1/workouts"
const baseExerciseUrl = "http://localhost:8080/api/v1/exercises"


const handleWorkoutSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        name: newWorkoutName.value
    }
    //console.log(bodyObj)

    await addWorkout(bodyObj);
    newWorkoutName.value = ''
}



async function addWorkout(bodyObj) {
    //console.log(bodyObj)
    const response = await fetch(`${baseWorkoutUrl}/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
    .catch(err => console.error(err.message))
    //console.log(response)
    if (response.status == 200) {
        getWorkouts(userId)
    }
}

async function getWorkouts(userId) {
    await fetch (`${baseWorkoutUrl}/user/${userId}`, {
        method: "GET", 
        headers: headers
    })
    .then(response => response.json())
    .then(data => {
        console.log(data)
        createWorkoutCards(data)})
    .catch(err => console.error(err))
}

const createWorkoutCards = async (array) => {
    workoutContainer.innerHTML = ''
    workoutSelect.innerHTML = ''
    array.forEach(async obj =>  {
        let workoutCard = document.createElement("div")
        
        workoutCard.setAttribute("id", obj.id)
        workoutCard.setAttribute("class", "workoutCard")
        workoutCard.innerHTML += `
        <h3 id="${obj.id}name" class="workoutName">${obj.name}</h3>
        <div class="deleteWorkout">
        <button type="button" class="workoutDeleteBtn" onclick="handleWorkoutDelete(${obj.id})">X</button>
        </div>`
        
        workoutContainer.appendChild(workoutCard)

        await getExercisesByWorkoutId(obj.id)

        
        const workoutOption = document.createElement("option")
        workoutOption.setAttribute("value", obj.id)
        workoutOption.innerHTML = `${obj.name}`
        workoutSelect.appendChild(workoutOption)
    })
}



async function addExerciseHandleSubmit(e) {
    e.preventDefault()
    
    id = workoutSelect.value
    console.log(id)
    bodyObj = {
        name: addExerciseName.value,
        sets: addExerciseSets.value,
        reps: addExerciseReps.value,
        weight: addExerciseWeight.value,
        distance: addExerciseDistance.value,
        duration: addExerciseDuration.value,
        speed: addExerciseSpeed.value
    }
    console.log(addExerciseName.value)
    

    await addExerciseToWorkout(id, bodyObj)
    addExerciseName.value = ''
    addExerciseSets.value = ''
    addExerciseReps.value = ''
    addExerciseWeight.value = ''
    addExerciseDistance.value = ''
    addExerciseDuration.value = ''
    addExerciseSpeed.value = ''
}

async function addExerciseToWorkout(id, bodyObj) {
    console.log(id)
    const response = await fetch(`${baseExerciseUrl}/workout/${id}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
    .catch(err => console.error(err.message))
    if (response.status == 200) {
        getWorkouts(userId)
    }
}

async function getExercisesByWorkoutId(id) {
    console.log(id)
    await fetch(`${baseExerciseUrl}/workout/${id}`, {
        method: "GET",
        headers: headers
    })
    .then(response => response.json())
    .then(data => {
        console.log(data)
        createExercises(data, id)
    })
    .catch(err => console.error(err.message))
}

function createExercises(array, workoutId) {
    console.log(array)
    array.forEach(obj => {
        const workoutCard = document.getElementById(`${workoutId}`)
        console.log(workoutCard)
        const exercise = document.createElement("div")
        exercise.setAttribute("id", `${obj.id}`)
        exercise.setAttribute("class", "exercise")
        exercise.innerHTML = `<p class="exerciceElement">${obj.name}</p>
        <p class="exerciseElement">${obj.sets}</p>
        <p class="exerciseElement">${obj.reps}</p>
        <p class="exerciseElement">${obj.weight}</p>
        <p class="exerciseElement">${obj.distance}</p>
        <p class="exerciseElement">${obj.duration}</p>
        <p class="exerciseElement">${obj.speed}</p>
        <a href="http://www.youtube.com/results?search_query=${youtubeDemo(obj.name)}" target="_blank" rel="noopener noreferrer">demo</a>
        <button type="button" class="deleteExerciseButton" onclick="handleExerciseDelete(${obj.id})">x</button>`
        workoutCard.appendChild(exercise)
    })
}

function youtubeDemo(name) {
    console.log(name)
    const words = name.split(' ')
    console.log(words)
    demoString = ''
    for(i=0; i < words.length; i++) {
        if (i == 0) {
            demoString += words[i]
        }
        else {
            demoString += `+${words[i]}`
        }
    }
    console.log(demoString)
    return demoString
}

async function handleExerciseDelete(id) {
    await fetch(`${baseExerciseUrl}/${id}`, {
        method: "DELETE",
        headers: headers
    })
    .catch(err => console.error(err))

    return getWorkouts(userId)
}

async function handleWorkoutDelete(workoutId) {
    await fetch(`${baseWorkoutUrl}/${workoutId}`, {
        method: "DELETE",
        headers: headers
    })
    .catch(err => console.error(err))

    return getWorkouts(userId)
}

getWorkouts(userId)

addExerciseButton.addEventListener("click", addExerciseHandleSubmit)
newWorkoutForm.addEventListener("submit", handleWorkoutSubmit)