import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class PicnicAnalyzer {
    private FileReader fileReader;

    public PicnicAnalyzer(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void analyze() {
        try {
            String content = fileReader.readFileContent();
            String[] words = splitContentIntoWords(content);

            // 1. Осуществить подсчет слов
            int wordCount = countWords(words);
            System.out.println("Количество слов в файле: " + wordCount);

            // 2. Найти самое длинное слово
            String longestWord = findLongestWord(words);
            System.out.println("Самое длинное слово в файле: " + longestWord);

            // 3. Вычислить частоту слов
            Map<String, Integer> wordFrequency = calculateWordFrequency(words);
            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    private String[] splitContentIntoWords(String content) {
        return content.split(" ");
    }

    private int countWords(String[] words) {
        return words.length;
    }

    private String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private Map<String, Integer> calculateWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("input.txt");
        PicnicAnalyzer analyzer = new PicnicAnalyzer(fileReader);
        analyzer.analyze();
    }
}
