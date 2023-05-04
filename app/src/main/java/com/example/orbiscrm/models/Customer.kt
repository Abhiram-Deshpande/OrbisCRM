package com.example.orbiscrm.models

class Customer {

     lateinit var name: String
     lateinit var contact: String
    lateinit var address: String
    lateinit var category: String
    constructor(){

    }
    constructor(name:String, contact:String, address:String,
                  category:String):this(){
        this.name =name
        this.contact=contact
        this.address =address
        this.category =category
    }
}