package org.example.model

import java.time.LocalDate
import java.util.Date


class Member : Record() {
    //дата напоминания
     lateinit var dateMember: LocalDate
     //по умолчанию новое напоминание
    var state : StateMember = StateMember.New

    override fun createRecord(text : String, dateCreate: LocalDate) {
        super.createRecord(text, dateCreate, TypeRecord.Member, -1);
    }

    fun setDateExecutionMember(value :LocalDate){
        dateMember = value
    }
    fun setStatusMember(value : StateMember){
        state = value;
    }
}