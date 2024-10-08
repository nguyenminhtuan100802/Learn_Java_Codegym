package BankManagement.service;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class FormatMoneyService {
    public static String formatMoney(double vietnamMoney){
        NumberFormat currencyFormatterVN = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return currencyFormatterVN.format(vietnamMoney);
    }

}
