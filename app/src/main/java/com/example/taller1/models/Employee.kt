package com.example.taller1.models;

class Employee(
    id: String,
    name: String,
    gender: String,
    email: String,
    var salary: Double,
    var dependecy: String,
    val year: Int,
    var role: Role,
    var employees: List<Employee> = emptyList()
    ): Person(id, name, gender, email) {
}

