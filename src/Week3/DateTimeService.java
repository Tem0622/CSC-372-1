package Week3;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeService {
    public void showDateTime(JTextArea textArea) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        textArea.setText(formatter.format(date));
    }
}
