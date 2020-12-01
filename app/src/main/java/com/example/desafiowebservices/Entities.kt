package com.example.desafiowebservices

data class Res(val data: Data)

data class Data(val offset: Int, var results: ArrayList<Results>)

data class Results(val id: Int, var title: String, var issueNumber: Int, var thumbnail:Thumbnail)

data class Thumbnail(val path: String, var extension: String)
