package cwaliimran.ext.datetime

import org.junit.Assert.*

import org.junit.Test
import java.util.Date

class DateTimeExtKtTest {

    @Test
    fun getCurrentFormattedDate() {
        val currentDate: String = "ddMMyyyy".getCurrentFormattedDate()
        System.out.println("currentDate $currentDate")
    }

    @Test
    fun getCurrentFormattedDateNumberInvalid() {
        val currentDate: String = "123".getCurrentFormattedDate()
        System.out.println("getCurrentFormattedDateNumber $currentDate")
    }

    @Test
    fun getCurrentFormattedDateInvalidFormat() {
        val currentDate: String = "asdfk".getCurrentFormattedDate()
        System.out.println("getCurrentFormattedDateInvalidFormat $currentDate")
    }

    @Test
    fun formatDate() {
        val date = "2023-03-29 08:39:12"
        date.formatDate(INPUT_FORMAT,OUT_PUT_FORMAT)
        println("formattedDate: " + date.formatDate(INPUT_FORMAT,OUT_PUT_FORMAT)) //formattedDate: 29 March 2023
        assertEquals("29 March 2023",date.formatDate(INPUT_FORMAT,OUT_PUT_FORMAT))
    }

    @Test
    fun dateToLong() {
        val date = "2023/03/29 : 08:39:12"
        System.out.println("dateToLong ${date.dateToLong(DATE_FORMAT)}")
        //out put will be 1680061152000
    }

    @Test
    fun convertLongToDate() {
//        val longDate = System.currentTimeMillis()
        val longDate = 1680061152000
        System.out.println("convertLongToDate ${longDate.convertLongToDate(DATE_FORMAT)}")

    }
    @Test
    fun dateToString() {
        val date = Date()
        System.out.println("dateToString ${date.dateToString(DATE_FORMAT)}")

    }
    @Test
    fun stringToDateObject() {
        val date = "2023/05/18 : 11:44:26"
        System.out.println("stringToDateObject ${date.stringToDateObject(DATE_FORMAT)}")
        //output Thu May 18 11:44:26 PKT 2023
    }
    @Test
    fun isDateInPast() {
        val date = "2023/05/19" //for today date only format it returns true because format is without time, and equal to today date
        System.out.println("isDateInPast ${date.isDateInPast("yyyy/MM/dd")}")
        //output Thu May 18 11:44:26 PKT 2023
    }

    @Test
    fun isDateInPastWithTime() {
        val date = "2023/05/18 : 12:44:26" //with time it returns exactly according to time stamp because it compares current calendar time
        System.out.println("isDateInPastWithTime ${date.isDateInPast(DATE_FORMAT)}")
    }
    @Test
    fun todayCalendarDateTest() {
        System.out.println("todayCalendarDate ${todayCalendarDate()}")
    }

    @Test
    fun minusDaysFromDateTest() {
        val date = "2023/05/18 : 12:44:26"
        System.out.println("minusDaysFromDateTest ${date.minusDaysFromDate(DATE_FORMAT, daysToSubtract = 6, monthsToSubtract = 4, yearsToSubtract = 1)}")
        // output 2023/05/16 : 12:44:26
    }
    @Test
    fun addDaysToDateTest() {
        val date = "2023/05/18 : 12:44:26"
        System.out.println("addDaysToDateTest ${date.addDaysToDate(DATE_FORMAT, daysToAdd = 6, monthsToAdd = 4, yearsToAdd = 1)}")
        // output 2024/09/24 : 12:44:26
    }
}