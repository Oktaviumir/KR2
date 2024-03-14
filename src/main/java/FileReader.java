import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String filename;

    public FileReader(String filename) {
        this.filename = filename;
    }

    public String readFileContent() throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        StringBuilder content = new StringBuilder();
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return content.toString();
    }
}
