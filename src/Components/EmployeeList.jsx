import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { deleteEmployee, fetchEmployees } from '../Services/EmployeeService';
import { useNavigate, useLocation } from 'react-router-dom';

function EmployeeList() {
    const [employees, setEmployees] = useState([]);
    const [message, setMessage] = useState(null);
    const navigator = useNavigate();
    const location = useLocation();

    useEffect(() => {
        getAllEmployees();

        // Show message if navigated from Add/Update
        if (location.state?.message) {
            setMessage(location.state);
            setTimeout(() => setMessage(null), 3000);
        }
    }, [location.state]);

    const getAllEmployees = () => {
        fetchEmployees()
            .then((data) => {
                setEmployees(data);
            })
            .catch((error) => {
                console.error(error);
            });
    };

    const handleDelete = (eid) => {
        const isConfirmed = window.confirm("Do You Want to delete Employee?");
        if (isConfirmed) {
            deleteEmployee(eid)
                .then(() => {
                    setEmployees(employees.filter(emp => emp.eid !== eid));
                    setMessage({ message: "Employee deleted successfully!", type: "danger" });
                    setTimeout(() => setMessage(null), 3000);
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    };

    const handleUpdate = (eid) => {
        navigator(`update-emp/${eid}`);
    };

    return (
        <div className="container mt-5">
            {message && (
                <div className={`alert alert-${message.type} alert-dismissible fade show`} role="alert">
                    {message.message}
                    <button type="button" className="btn-close" onClick={() => setMessage(null)}></button>
                </div>
            )}

            <h2 className="mb-4 text-center">Employee Details</h2>
            <table className="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee Name</th>
                        <th>Age</th>
                        <th>Mobile Number</th>
                        <th>Salary</th>
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
                                <button onClick={() => handleDelete(employee.eid)} className='btn btn-outline-danger me-2'>Delete</button>
                                <button onClick={() => handleUpdate(employee.eid)} className='btn btn-outline-info'>Update</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <button className='btn btn-success w-100' onClick={() => navigator("/add-emp")}>Add New Employee</button>
        </div>
    );
}

export default EmployeeList;
