package com.example.desafiowebservices

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

data class Res(val data: Data)

data class Data(val offset: Int, var results: ArrayList<Results>)

data class Results(val id: Int, var title: String, var issueNumber: Int, var thumbnail:Thumbnail, var description: String, var pageCount: Int, var prices: Array<ComicPrice>, var modified: Date, var dates: Array<DateHq>): Serializable

data class Thumbnail(val path: String, var extension: String): Serializable

data class ComicPrice(var type: String, var price: Float): Serializable

data class DateHq(var type: String, var date: Date): Serializable