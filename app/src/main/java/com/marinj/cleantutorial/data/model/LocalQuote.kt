package com.marinj.cleantutorial.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "quotes", indices = [Index("message")])
data class LocalQuote(

        @PrimaryKey
        @ColumnInfo(name = "author")
        val author: String,

        @ColumnInfo(name = "message")
        val message: String
)