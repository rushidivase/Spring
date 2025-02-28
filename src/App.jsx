import React from 'react'
import { Route, Routes } from 'react-router-dom'
import EmployeeList from './Components/EmployeeList'
import AddEmployeeComponent from './Components/AddEmployeeComponent'

function App() {
  return (
    <div>

      <Routes>
        <Route path='/' element={<EmployeeList />} />
        <Route path='/add-emp' element={<AddEmployeeComponent />} />
      </Routes>
    </div>
  )
}

export default App