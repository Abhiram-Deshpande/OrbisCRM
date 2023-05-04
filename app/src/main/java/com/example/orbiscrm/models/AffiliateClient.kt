package com.example.orbiscrm.models

class AffiliateClient {
    lateinit var affiliate_client_name:String
    lateinit var company_name:String
    lateinit var revenue_stream_generated:String
    lateinit var sub_clients_affiliated:String
    lateinit var location:String

    constructor(){

    }
    constructor(affiliate_client_name:String,
                company_name:String,
                revenue_stream_generated:String,
                sub_clients_affiliated:String,
                location:String):this()
    {
        this.affiliate_client_name= affiliate_client_name
        this.company_name=company_name
        this.revenue_stream_generated =revenue_stream_generated
        this.sub_clients_affiliated= sub_clients_affiliated
        this.location= location
    }
}