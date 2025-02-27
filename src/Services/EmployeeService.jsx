import axios from "axios";

const BASE_REST_API = "http://localhost:8090/emp-service/"; 

export const fetchEmployees = ()=> axios.get(BASE_REST_API).then(res=>res.data);
