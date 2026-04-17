import helper.Third
import java.lang.System.exit
import java.util.Scanner

val scanner = Scanner(System.`in`)
val pathXML = "data/records.xml";
val pathJSON = "data/records.json";
val pathConfig = "data/config.ini";

var dataKey  = HashMap<String, Third<String>>()

fun main(){
    println("Тестовая версия программы планера (консольная версия)")
    createKey()
    while(true) {
        start();
    }
}
fun createKey(){
    dataKey.clear();
    dataKey.put("-cN", Third<String>("c", "N", "Добавить заметку"));
    dataKey.put("-cM", Third<String>("c", "M", "Добавить напоминание"));
    dataKey.put("-r", Third<String>("r", "", "Удалить запись"));
    dataKey.put("-p", Third<String>("p", "", "Вывести все записи"));
    dataKey.put("-uT", Third<String>("u", "", "Добавить заголовок"));
    dataKey.put("-tags", Third<String>("u", "", "Добавить теги"));
    dataKey.put("-x", Third<String>("x", "", "Выйти из программы"));
}
fun start(){
    printHelp();
    println("Введите нужное действие: ");
    var value = scanner.next()
    checkKey(value);
}
//печать справки
fun printHelp(){
    for (index in 0 until dataKey.keys.size step 1){
        var key = dataKey.keys.elementAt(index)
        var value = dataKey.get(key);
        //println(key);
        println(key+" "+value?.third);
    }
    println()
}
//проверка введенного ключа
fun checkKey(key:String){
    if(!dataKey.containsKey(key)){
        println("Нет такого значения")
        println()
    }else{
        //System.out.println(dataKey.get(key));
        var data = dataKey.get(key);
        if(data?.first.equals("c")){
            System.out.println("CREATE")
            /*
            System.out.print("Введите текст: ");
            var text = in.next();
            var date = LocalDate.now();
            Record record = new Note();
            if(data.second().equals("N")){
                //record = new Note();
                record.createRecord(text, date);
            }else if(data.second().equals("M")){
                record = new Member();
                record.createRecord(text, date);
            }
            saveRecord(record);
            */
        }
        if(data?.first.equals("p")){
            println("PRINT")
            /*
            //var recs = xml.readRecords();
            var recs = workWithData.readRecords();
            recs.forEach(rec->System.out.println(rec.getData()));
            System.out.println();
            */
        }
        if(data?.first.equals("x")){
            System.out.println("Выход из программы");
            exit(0)
        }
    }
}