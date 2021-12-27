package lesson2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLesson2 {
    public static int maxFrequentlyWordsUpdate(int count, int maxCount, List<String> maxFrequentlyWords, String word) {
        if (count >= maxCount) {
            if (count > maxCount) {
                maxFrequentlyWords = new ArrayList<>();
            }
            maxCount = count;
            if (!maxFrequentlyWords.contains(word)) {
                maxFrequentlyWords.add(word);
            }
        }
        return maxCount;
    }

    public static void countWords(String filePath) {
        try {
            Stream<String> inputStrings = Files.lines(Path.of(filePath).toAbsolutePath());
            List<String> sortedWords = inputStrings
                    .map(l -> l.split("[^a-zA-Zа-яА-Я]+"))
                    .flatMap(Arrays::stream)
                    .map(String::toLowerCase)
                    .filter(s -> !s.equals(""))
                    .sorted()
                    .collect(Collectors.toList());
            String prevWord = sortedWords.get(0);
            int count = 0;
            int maxCount = 0;
            List<String> maxFrequentlyWords = new ArrayList<>();
            for (int i = 0; i < sortedWords.size(); i++) {
                if (prevWord.equals(sortedWords.get(i))) {
                    count++;
                    if (i == sortedWords.size() - 1) {
                        maxCount = maxFrequentlyWordsUpdate(count, maxCount, maxFrequentlyWords, sortedWords.get(i));
                        System.out.println(sortedWords.get(i) + "  x" + count);
                    }
                } else {
                    maxCount = maxFrequentlyWordsUpdate(count, maxCount, maxFrequentlyWords, sortedWords.get(i));
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
