package cwaliimran.ext.datetime


import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


const val DATE_FORMAT = "yyyy/MM/dd : HH:mm:ss"

/*
 Pass the date format in string and method will return string formatted date
 below is the example you can use the app

  val format = "yyyy/MM/dd : HH:mm:ss"
 val currentDate: String = format.getCurrentFormattedDate()

 invalid date format would result in error so make sure to pass the correct date format
* */
fun String.getCurrentFormattedDate(): String {
    var formattedDate = ""
    try {
        val date = Date(System.currentTimeMillis())
        val formatter = SimpleDateFormat(this, Locale.getDefault())
        formattedDate = formatter.format(date)
    } catch (e: Exception) {
        e.localizedMessage.toString()
    }
    return formattedDate
}

/*
 pass the input and output format in function params (sample is added below)
 this function requires date in extension
 below is the example you can use the app
        val date = "2023-03-29 08:39:12"
        date.formatDate(INPUT_FORMAT,OUT_PUT_FORMAT)

        the output will be //formattedDate: 29 March 2023

        if the invalid date format is passed it will result in Unparseable date: "2023-03-29 23adf08:39:12" error
* */
const val INPUT_FORMAT = "yyyy-MM-dd HH:mm:ss"
const val OUT_PUT_FORMAT = "dd MMMM yyyy"

//format date
fun String.formatDate(inputFormat: String, outputFormat: String): String {
    var formattedDate = ""
    try {
        val date = SimpleDateFormat(inputFormat, Locale.getDefault()).parse(this)    // parse input
        formattedDate = SimpleDateFormat(
            outputFormat, Locale.getDefault()
        ).format(date as Date)    // format output

    } catch (e: ParseException) {
        e.localizedMessage.toString()
    }
    return formattedDate
}


/*
convert date to long requires date and format of the date
  val date = "2023/03/29 : 08:39:12"
  val format = "yyyy/MM/dd : HH:mm:ss"
    date.dateToLong(format)
        //out put will be 1680061152000
* */
fun String.dateToLong(formatPattern: String): Long {
    var dateInLong = 0L
    try {
        val formatter = SimpleDateFormat(formatPattern, Locale.getDefault())
        val date = formatter.parse(this)
        if (date != null) {
            dateInLong = date.time
        }
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return dateInLong
}

/*
convert long to date requires date (long) and format of the output date as parameter to get current time in millis you can use val date = System.currentTimeMillis()
 val date = 1680061152000
  val format = "yyyy/MM/dd : HH:mm:ss"
    date.convertLongToDate(format)
        //out put will be 2023/03/29 : 08:39:12
* */

fun Long.convertLongToDate(outputFormat: String): String {
    var formattedDate = ""
    try {
        val date = Date(this)
        val formatter = SimpleDateFormat(outputFormat, Locale.getDefault())
        formattedDate = formatter.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return formattedDate
}

/*
convert date to string requires date (Date()) and format of the output date as parameter
 val date = Date()
  val format = "yyyy/MM/dd : HH:mm:ss"
    date.dateToString(format)
        //out put will be 2023/05/18 : 11:44:26
* */
fun Date.dateToString(outputFormat: String): String {
    var formattedDate = ""
    try {
        val formatter = SimpleDateFormat(outputFormat, Locale.getDefault())
        formattedDate = formatter.format(this)
    } catch (e: Exception) {
        e.localizedMessage
    }
    return formattedDate
}


/*
convert string to date requires date (String) and format of the output date as parameter
 val date = Date()
  val format = "yyyy/MM/dd : HH:mm:ss"
    date.dateToString(format)
        //out put will be 2023/05/18 : 11:44:26
* */
fun String.stringToDateObject(outputFormat: String): Date {
    var formattedDate = Date()
    try {
        val dateFormat = SimpleDateFormat(outputFormat, Locale.getDefault())
        formattedDate = dateFormat.parse(this)
    } catch (e: Exception) {
        e.localizedMessage
    }
    return formattedDate
}


//check if date is less than today or date is in past
/*
SCENARIO 1
 val date = "2023/05/18" //for today date only format it returns true because format is without time
   SCENARIO 2
   val date = "2023/05/18 : 12:44:26" //with time it returns exactly according to time stamp because it compares current calendar time

*/
fun String.isDateInPast(formatPattern: String): Boolean {
    try {
        return SimpleDateFormat(
            formatPattern, Locale.getDefault()
        ).parse(this)?.before(todayCalendarDate().time) == true
    } catch (e: Exception) {
        return true
    }
}

//today calendar date
fun todayCalendarDate(): Calendar {
    return Calendar.getInstance()
}

//yesterday's calendar date
fun yesterdayCalendarDate(): Calendar {
    val today = Calendar.getInstance()
    today.add(Calendar.DATE, -1)
    return today
}


/*
subtract days from date
  val date = "2023/05/18 : 12:44:26"
  val format = "yyyy/MM/dd : HH:mm:ss"
    date.minusDaysFromDate(format, daysToSubtract = 6, monthsToSubtract = 4, yearsToSubtract = 1)
        //out put will be  2022/01/12 : 12:44:26
* */
fun String.minusDaysFromDate(
    formatPattern: String,
    daysToSubtract: Int? = 0,
    monthsToSubtract: Int? = 0,
    yearsToSubtract: Int? = 0
): String {
    var formattedDate = ""
    try {

        val dateFormat = SimpleDateFormat(formatPattern, Locale.getDefault())
        val date = dateFormat.parse(this)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract!!)
        calendar.add(Calendar.MONTH, -monthsToSubtract!!)
        calendar.add(Calendar.YEAR, -yearsToSubtract!!)

        val subtractedDate = calendar.time
        formattedDate = dateFormat.format(subtractedDate)
    } catch (e: Exception) {
        e.localizedMessage
    }
    return formattedDate
}

/*
add days to date
  val date = "2023/05/18 : 12:44:26"
  val format = "yyyy/MM/dd : HH:mm:ss"
    date.minusDaysFromDate(format, daysToAdd = 6, monthsToAdd = 4, yearsToAdd = 1)
        //out put will be  2024/09/24 : 12:44:26
* */
fun String.addDaysToDate(
    formatPattern: String, daysToAdd: Int? = 0, monthsToAdd: Int? = 0, yearsToAdd: Int? = 0
): String {
    var formattedDate = ""
    try {

        val dateFormat = SimpleDateFormat(formatPattern, Locale.getDefault())
        val date = dateFormat.parse(this)
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd!!)
        calendar.add(Calendar.MONTH, monthsToAdd!!)
        calendar.add(Calendar.YEAR, yearsToAdd!!)

        val addedDate = calendar.time
        formattedDate = dateFormat.format(addedDate)
    } catch (e: Exception) {
        e.localizedMessage
    }
    return formattedDate
}
