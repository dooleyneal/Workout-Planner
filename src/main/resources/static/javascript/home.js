const cookieArr = document.cookie.split(`=`)
const userId = cookieArr[1]

const newWorkoutForm = document.getElementById(`newWorkout`)
const workoutContainer = document.getElementById(`workoutContainer`)

const headers = {
    'Content-Type': 'aplication/json'
}

const baseUrl = "http://localhost:8080/api/v1/exercises"
