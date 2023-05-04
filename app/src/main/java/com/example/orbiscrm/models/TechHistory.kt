package com.example.orbiscrm.models

class TechHistory {

    lateinit var event_title: String
    lateinit var what_was_the_actual_problem: String
    lateinit var tech_history_what_steps_were_taken: String
    constructor(){

    }
    constructor( event_title: String,
                 what_was_the_actual_problem: String,
                 tech_history_what_steps_were_taken: String):this(){
        this.event_title =event_title
        this.what_was_the_actual_problem=what_was_the_actual_problem
        this.tech_history_what_steps_were_taken =tech_history_what_steps_were_taken
    }
}