import React, { useState } from 'react'
import { insertEmployee } from '../Services/EmployeeService';
import { useNavigate } from 'react-router-dom';

function AddEmployeeComponent() {

    const [eid, setEid] = useState();
    const [ename, setEname] = useState();
    const [age, setAge] = useState();
    const [mono, setMono] = useState();
    const [salary, setSalary] = useState();

    const navigator = useNavigate();

    function saveEmployee() {
        const employee = {eid, ename, age, mono, salary};
        //console.log(employee);
        insertEmployee(employee).then((response)=>{
            console.log(response.data);
        }).catch((error)=>{
            console.log(error);
        })

      navigator("/");
    }

    return (
        <div className='container'>
            <div className='row justify-content-center'>
                <div className='col-5 border shadow p-3 mt-5'>
                    <h2 className='text-center display-6 mb-3'>Add Employee</h2>
                    <input type='text' className='form-control mb-2' placeholder='Enter Employee Id'
                        value={eid} onChange={(e) => { setEid(e.target.value) }} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Employee Name'
                        value={ename} onChange={(e) => { setEname(e.target.value) }} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Age'
                        value={age} onChange={(e) => { setAge(e.target.value) }} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Mobile Number'
                        value={mono} onChange={(e) => { setMono(e.target.value) }} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Salary'
                        value={salary} onChange={(e) => { setSalary(e.target.value) }} />

                    <button onClick={saveEmployee} type='submit' className='btn btn-info w-100'>Submit</button>
                </div>
            </div>
        </div>

    )
}

export default AddEmployeeComponent