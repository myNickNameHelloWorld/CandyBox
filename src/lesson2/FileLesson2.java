package lesson2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLesson2 {
    public static int maxFrequentlyWordsUpdate(int count, int maxCount, Set<String> maxFrequentlyWords, String word) {
        if (count >= maxCount) {
            if (count > maxCount) {
                maxFrequentlyWords = new HashSet<>();
                maxCount = count;
            }
            maxFrequentlyWords.add(word);
        }
        return maxCount;
    }

    public static void countWords(String filePath) {
        try {
            Path path = Path.of(filePath);
            if (!Files.exists(path)) {
                path = Path.of("src/").resolve(path);
            } else {
                path = path.toAbsolutePath();
            }
            Stream<String> inputStrings = Files.lines(path);
            List<String> sortedWords = inputStrings
                    .map(l -> l.split("[^a-zA-Zа-яА-Я0-9]+"))
                    .flatMap(Arrays::stream)
                    .map(String::toLowerCase)
                    .filter(s -> !s.equals(""))
                    .sorted()
                    .collect(Collectors.toList());
            String prevWord = sortedWords.get(0);
            int count = 0;
            int maxCount = 0;
            Set<String> maxFrequentlyWords = new HashSet<>();
            for (int i = 0; i < sortedWords.size(); i++) {
                if (prevWord.equals(sortedWords.get(i))) {
                    count++;
                    if (i == sortedWords.size() - 1) {
                        maxCount = maxFrequentlyWordsUpdate(count, maxCount, maxFrequentlyWords, sortedWords.get(i));
                        System.out.println(sortedWords.get(i) + "  x" + count);
                    }
                } else {
                    maxCount = maxFrequentlyWordsUpdate(count, maxCount, maxFrequentlyWords, prevWord);
                    System.out.println(prevWord + "  x" + count);
                    count = 1;
                    prevWord = sortedWords.get(i);
                }
            }
            System.out.println("Most frequently words:");
            for (String maxFrequentlyWord : maxFrequentlyWords) {
                System.out.println(maxFrequentlyWord + "  x" + maxCount + " percentage : " + (maxCount * 100 / sortedWords.size()) + "%");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
