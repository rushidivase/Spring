import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { deleteEmployee, fetchEmployees } from '../Services/EmployeeService';
import { useNavigate } from 'react-router-dom';

function EmployeeList() {

    const [employees, setEmployees] = useState([]);
    const navigator = useNavigate();

    // const employees = [
    //     {
    //         eid: 101,
    //         ename: "Siya",
    //         age: 40,
    //         mono: 8765445678,
    //         salary: 80000.0,
    //     },
    //     {
    //         eid: 102,
    //         ename: "John",
    //         age: 35,
    //         mono: 9876543210,
    //         salary: 75000.0,
    //     },
    // ];


    const handleDelete = (eid) => {
        //console.log(eid);
        const isConfirmed = window.confirm("Do You Want to delete Employee..!");
        if(isConfirmed)
        {
            deleteEmployee(eid).then((response) => {
                console.log(response.data);
            }).catch((error) => {
                console.log(error);
            })
        }
    }

    useEffect(() => {
        getAllEmployees();
    }, [handleDelete])

    const getAllEmployees = () => {

        fetchEmployees().then((data) => {
            setEmployees(data);
        }).catch((error) => {
            console.log(error);
        })
    }



    return (
        <div className="container mt-5">
            <h2 className="mb-4 text-center">Employee Details</h2>
            <table className="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th scope="col">Employee Id</th>
                        <th scope="col">Employee Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Mobile Number</th>
                        <th scope="col">Salary</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map((employee) => (
                        <tr key={employee.eid}>

                            <td>{employee.eid}</td>

                            <td>{employee.ename}</td>

                            <td>{employee.age}</td>

                            <td>{employee.mono}</td>

                            <td>{employee.salary}</td>
                            <td>
                                <button onClick={() => { handleDelete(employee.eid) }} className='btn btn-outline-danger'>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <button className='btn btn-success w-100' onClick={() => { navigator("/add-emp") }}>Add New Employee</button>
        </div>
    );
}

export default EmployeeList;
