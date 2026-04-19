package org.example.model

import java.time.LocalDate
import java.util.Collections

abstract class Record {
    //номер (id)
    var num : Int = -1
    //текст и заголовок
    lateinit var text: String
    lateinit var title : String
    //дата создания
    lateinit var dateCreate: LocalDate
    lateinit var type:TypeRecord
    lateinit var tags: MutableList<String>

    fun createRecord(text : String, dateCreate : LocalDate, type:TypeRecord, num_:Int) {
        if(num_!=-1) {
            num = num_
        }
        this.text = text
        this.title = ""
        this.dateCreate = dateCreate
        this.type = type
        tags = Collections.emptyList()
    }

    fun getTagsRecord():List<String>{
        return tags;
    }
    //здесь надо добавить проверку на входные данные
    //если не пустые, то добавляем
    fun setTagRecord(tag : String){
        if(tag.length!=0){
            if(!tags.contains(tag)){
                tags.add(tag);
            }
        }
    }
    fun setTitleRecord(title:String){
        this.title = title;
    }
    fun  getTypeRecord() : String{
        var strType : String = ""
        strType = when(type){
            is TypeRecord.Note->"Note"
            is TypeRecord.Member->"Member"
            is TypeRecord.No->""
        }
        return  strType;
    }
    abstract fun createRecord(text : String, dateCreate : LocalDate)

    fun getTextRecord() : String{
        return text
    }
    fun getDateCreateRecord() : String{
        return dateCreate.toString()
    }
    fun getTitleRecord() : String{
        return title
    }
    fun setNumRecord(value: Int){
        num = value
    }
    fun getNumRecord() : Int{
        return num;
    }
    fun getDataRecord() : String{
        var strType : String = when(type){
            is TypeRecord.Member->"Напоминание"
            is TypeRecord.Note->"Заметка"
            is TypeRecord.No->""
        }
        var data = "Id: "+num+"\nТип: "+strType+"\n"
        var test : String = "cvkcjvk"
        if(title.length!=0)
            data+="Заголовок: "+title+"\n";
        if(!tags.isEmpty()){
            var str : String =""
            tags.forEach {teg_->
                str+=teg_+" "
            }
            data+="Теги: "+str+"\n";
        }
        data+="Текст:"+text+"\nДата создания: "+dateCreate
        data+="\n-------------------------------------------------------------";
        return data;
    }
    fun setTypeRecord(value : TypeRecord){
        type = value;
    }

    fun removeTitleRecord() {
        title = ""
    }
}