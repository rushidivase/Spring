import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { fetchEmployees } from '../Services/EmployeeService';

function EmployeeList() {

    const [employees, setEmployees] = useState([]);

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

    useEffect(() => {
        getAllEmployees();
    }, [])

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
                    </tr>
                </thead>
                <tbody>
                    {employees.map((employee) => (
                        <tr>

                            <td>{employee.eid}</td>

                            <td>{employee.ename}</td>

                            <td>{employee.age}</td>

                            <td>{employee.mono}</td>

                            <td>{employee.salary}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default EmployeeList;
