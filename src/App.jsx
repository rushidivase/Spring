import React from 'react'
import { Route, Routes } from 'react-router-dom'
import EmployeeList from './Components/EmployeeList'

function App() {
  return (
    <div>

      <Routes>
        <Route path='/' element={<EmployeeList />} />
      </Routes>
    </div>
  )
}

export default App