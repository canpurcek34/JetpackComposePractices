package com.canpurcek.jetpackcomposepractices.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


//entity is looks like db
@Entity(tableName = "person")
data class PersonEntitiy(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var personId: Int,
    @ColumnInfo(name = "name") @NotNull var name: String,
    @ColumnInfo(name = "number") @NotNull var number: Int
)
