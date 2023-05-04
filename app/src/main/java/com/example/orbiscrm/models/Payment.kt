package com.example.orbiscrm.models

class Payment {

    lateinit var payment_issuer: String
    lateinit var amount: String
    lateinit var payment_app: String
    lateinit var payment_date: String
    lateinit var payment_status: String
    constructor(){

    }
    constructor(payment_issuer:String, amount:String, payment_app:String,
                payment_date:String,payment_status:String):this(){
        this.payment_issuer =payment_issuer
        this.amount=amount
        this.payment_app =payment_app
        this.payment_date =payment_date
        this.payment_status = payment_status
    }
}