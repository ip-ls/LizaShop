package com.liza.lizashop.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.sql.Blob

@Entity(indices = [Index(value = ["phone"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
//    @ColumnInfo(name = "image_user", typeAffinity = ColumnInfo.BLOB) val imageUser: Array<Byte>?,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String,
    @ColumnInfo(name = "balance") val balance: Int = 0,
    @ColumnInfo(name = "hash_password") val hashPassword: String
)