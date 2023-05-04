package com.example.orbiscrm.models

class CallHistory {
    lateinit var call_attendant:String
    lateinit var call_duration_minutes:String
    lateinit var call_duration_seconds:String
    lateinit var caller:String
    lateinit var call_summary:String

     constructor(){

     }
    constructor(call_attendant:String,
                call_duration_minutes:String,
                call_duration_seconds:String,
                caller:String,
                call_summary:String):this()
    {
        this.call_attendant= call_attendant
        this.call_summary=call_summary
        this.caller =caller
        this.call_duration_minutes= call_duration_minutes
        this.call_duration_seconds= call_duration_seconds
    }
}