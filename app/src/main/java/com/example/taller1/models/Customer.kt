package com.example.taller1.models

class Customer (
    id: String,
    name: String,
    gender: String,
    email: String,
    var address: String,
    var phone: String
): Person(id, name, gender, email) {
}