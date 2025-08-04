import java.time.*;
import java.io.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}