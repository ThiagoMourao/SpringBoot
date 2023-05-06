import axios from 'axios';

export default axios.create({
    baseURL:'https://8847-186-195-141-133.ngrok-free.app',
    headers: {"ngrok-skip-browser-warning": "true",
    "Access-Control-Allow-Origin": "*"}
});