package com.example.orbiscrm.models

class ResolvedEmail
 {

    lateinit var title:String
    lateinit var body:String
    lateinit var review:String
    lateinit var client_name:String

    constructor(){

    }
    constructor(title:String,
                body:String,
                review:String,
                client_name:String):this(){
        this.title=title
        this.body =body
        this.review = review
        this.client_name = client_name
    }
}