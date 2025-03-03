import React, { useEffect, useState } from 'react';
import { getEmployeeById, insertEmployee, updateEmployee } from '../Services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

function AddEmployeeComponent() {
    const [eid, setEid] = useState('');
    const [ename, setEname] = useState('');
    const [age, setAge] = useState('');
    const [mono, setMono] = useState('');
    const [salary, setSalary] = useState('');

    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        if (id) {
            getEmployeeById(id)
                .then(response => {
                    const data = response.data;
                    setEid(data.eid);
                    setEname(data.ename);
                    setAge(data.age);
                    setMono(data.mono);
                    setSalary(data.salary);
                })
                .catch(error => console.error(error));
        }
    }, [id]);

    const saveOrUpdateEmployee = () => {
        const employee = { eid, ename, age, mono, salary };

        if (id) {
            updateEmployee(employee)
                .then(() => navigate("/", { state: { message: "Employee updated successfully!", type: "success" } }))
                .catch(error => console.error(error));
        } else {
            insertEmployee(employee)
                .then(() => navigate("/", { state: { message: "Employee added successfully!", type: "success" } }))
                .catch(error => console.error(error));
        }
    };

    return (
        <div className='container'>
            <div className='row justify-content-center'>
                <div className='col-5 border shadow p-3 mt-5'>
                    <h2 className='text-center display-6 mb-3'>{id ? "Update Employee" : "Add Employee"}</h2>

                    <input type='text' className='form-control mb-2' placeholder='Enter Employee Id'
                        value={eid} onChange={(e) => setEid(e.target.value)} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Employee Name'
                        value={ename} onChange={(e) => setEname(e.target.value)} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Age'
                        value={age} onChange={(e) => setAge(e.target.value)} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Mobile Number'
                        value={mono} onChange={(e) => setMono(e.target.value)} />

                    <input type='text' className='form-control mb-2' placeholder='Enter Salary'
                        value={salary} onChange={(e) => setSalary(e.target.value)} />

                    <button onClick={saveOrUpdateEmployee} type='submit' className='btn btn-info w-100'>Submit</button>
                </div>
            </div>
        </div>
    );
}

export default AddEmployeeComponent;
