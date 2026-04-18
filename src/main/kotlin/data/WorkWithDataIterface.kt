package data

interface WorkWithDataIterface {
    fun writeRecord(record : Record)
    fun readRecords() : List<Record>
}