package com.example.taller1

import androidx.constraintlayout.solver.widgets.analyzer.Dependency
import com.example.taller1.models.Customer
import com.example.taller1.models.Employee
import com.example.taller1.models.Role

fun main() {
    println(successiveDivision(12, 3))
    val customers = loadCustomers()
    val employees = loadEmployees()
    val roles = loadRoles()
    //addCustomer(customers)
    //customerPercentage(customers)
    //deleteCustomer(customers)
    //updateCustomer(customers)
    //addEmployee(employees, roles)
    //println(employeesByRol(employees, "vendedor"))
    val oldestEmployee = oldestEmployee(employees)
    println("empleado ${oldestEmployee?.name} pertenece a la dependencia ${oldestEmployee?.dependecy}")
}

fun successiveDivision(number1: Int, number2: Int, counter:Int = 0): Int {
    if (number1 < number2) return counter
    return successiveDivision(number1 - number2, number2, counter +1)
}
// --------------------------- CLIENTES -----------------------------------------
fun addCustomer(customers: MutableList<Customer>){
    println("Ingrese su id:  ")
    val id = readLine().toString()

    println("Ingrese su nombre:  ")
    val name = readLine().toString()

    println("Ingrese su genero:  ")
    val gender = readLine().toString()

    println("Ingrese su direccion:  ")
    val address = readLine().toString()

    println("Ingrese su correo:  ")
    val email = readLine().toString()

    println("Ingrese su telefono:  ")
    val phone = readLine().toString()

    customers.add(Customer(id, name, gender, email, address, phone))
    println(customers.size)
}

fun updateCustomer(customers: MutableList<Customer>){
    println("Ingrese el id: ")
    val id = readLine().toString()

    val customer = customers.find { it.id == id }

    if (customer != null) {
        println("Ingrese su nuevo genero:  ")
        val gender = readLine().toString()

        println("Ingrese su nueva direccion:  ")
        val address = readLine().toString()

        println("Ingrese su nuevo correo:  ")
        val email = readLine().toString()

        println("Ingrese su nuevo telefono:  ")
        val phone = readLine().toString()

        customer.gender = gender
        customer.address = address
        customer.email = email
        customer.phone = phone

        println("Los datos que se actualizaron fueron: ${customer.gender}, ${customer.address}, ${customer.email}, ${customer.phone} ")
    } else {
        println("Este cliente no se encontró")
    }

}
fun deleteCustomer(customers: MutableList<Customer>) {
    println("Ingrese el id: ")
    val id = readLine().toString()

    val customer = customers.find { it.id == id }

    if (customer != null) {
        customers.remove(customer)
        println(customers.size)
    } else {
        println("Este cliente no se encontró")
    }
}

fun customerPercentage(customers: MutableList<Customer>){
    if(customers.size==0){
        println("No hay clientes registrados")
    }else{
        val malePercetage = ( customers.count {it.gender=="masculino"} / customers.size.toFloat()) * 100
        val femalePercetage = (customers.count{it.gender=="femenino"} / customers.size.toFloat()) * 100

        println("El % de clientes masculinos es: $malePercetage y de femenino es: $femalePercetage")
    }

}

fun loadCustomers():MutableList<Customer>{
    val customer1 = Customer("1", "c1", "masculino", "fgh", "tyu", "456")
    val customer2 = Customer("2", "c2", "femenino", "hjk", "ghj", "789")
    val customer3 = Customer("3", "c3", "masculino", "yuio", "rtyu", "78")
    val customer4 = Customer("4", "c4", "femenino", "rtyu", "bn", "789")

    return mutableListOf(customer1, customer2, customer3, customer4)
}

// -------------------- EMPLEADOS--------------------------------------------


 fun addEmployee(employees: MutableList<Employee>, roles: List<Role>){
     println("Ingrese su id:  ")
     val id = readLine().toString()

     println("Ingrese su nombre:  ")
     val name = readLine().toString()

     println("Ingrese su genero:  ")
     val gender = readLine().toString()

     println("Ingrese su correo:  ")
     val email = readLine().toString()

     println("Ingrese su salario:  ")
     val salary = readLine()?.toDoubleOrNull() ?: 0.0

     println("Ingrese su dependencia: ")
     val dependency = readLine().toString()

     println("Ingrese su año de ingreso a la empresa: ")
     val year = readLine()?.toIntOrNull() ?: 0

     println("Ingrese su rol: ")
     val role = roles.find { it.name == readLine().orEmpty().toString() } ?: Role("ninguno", 0)

//     println("Ingrese sus subordinados: ")
//     val employee = employees.find {it.id == readLine().toString()}
     val employeesList = mutableListOf<Employee>()
//     if (employee != null) {
//         employeesList.add(employee)
//     }

     employees.add(Employee(id, name, gender, email, salary, dependency, year, role, employeesList ))
     println(employees.size)
 }
fun updateEmployee(employees: MutableList<Employee>){
    println("Ingrese el id: ")
    val id = readLine().toString()

    val employee= employees.find { it.id == id }

    if (employee != null) {
        println("Ingrese su nuevo genero:  ")
        val gender = readLine().toString()

        println("Ingrese su nuevo correo:  ")
        val email = readLine().toString()

        println("Ingrese su nuevo salario:  ")
        val salary = readLine()?.toDoubleOrNull() ?: 0.0

        println("Ingrese su nueva dependencia:  ")
        val dependency = readLine().toString()

        employee.gender = gender
        employee.email = email
        employee.salary = salary
        employee.dependecy = dependency

        println("Los datos que se actualizaron fueron: ${employee.gender}, ${employee.email}, ${employee.salary}, ${employee.dependecy} ")
    } else {
        println("Este empleado no se encontró")
    }

}
fun deleteEmployee(employees: MutableList<Employee>) {
    println("Ingrese el id: ")
    val id = readLine().toString()

    val employee = employees.find { it.id == id }

    if (employee != null) {
        employees.remove(employee)
        println(employees.size)
    } else {
        println("Este empleado no se encontró")
    }
}
fun totalPayroll(employees: List<Employee>):Double{
    return employees.sumOf{it.salary}
}

fun payrollByDependency(employees: List<Employee>, dependency: String):Double{
    return employees
        .filter { it.dependecy == dependency }
        .sumOf {it.salary}

}

fun employeesByRol(employees: List<Employee>, role:String):Int{
    return employees.count {it.role.name ==role}

}
fun oldestEmployee(employees: List<Employee>): Employee? {
    return employees.minByOrNull { it.year }

}

fun loadEmployees():MutableList<Employee>{
    val employee1 = Employee("1", "e1", "masculino", "dio",56.000,"vendedor", 2023,Role("ninguno",0))
    val employee2 = Employee("2", "e2", "femenino", "hjk", 57.000,"vhj", 2022,Role("vendedor", 1))
    val employee3 = Employee("3", "e3", "masculino", "yuio", 58.000,"vendedor", 2020,Role("admin",2))
    val employee4 = Employee("4", "e4", "femenino", "rtyu", 59.000,"vhj", 2021,Role("vendedor",1))

    return mutableListOf(employee1, employee2, employee3, employee4)
}

fun loadRoles():MutableList<Role>{
    val role1 = Role("vendedor", 1)
    val role2 = Role("administrador", 2)

    return mutableListOf(role1, role2)
}






