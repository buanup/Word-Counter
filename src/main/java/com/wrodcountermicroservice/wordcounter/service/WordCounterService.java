package com.wrodcountermicroservice.wordcounter.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrodcountermicroservice.wordcounter.domain.Translator;

@Service
public class WordCounterService {
    private final Map<String, Integer> wordCountMap = new HashMap<>();
    private final Translator translator;

    @Autowired
    public WordCounterService(Translator translator) {
        this.translator = translator;
    }

    public void addWords(String... words) {
        for (String word : words) {
            if (isValidWord(word)) {
                String englishWord = translator.translate(word);
                wordCountMap.put(englishWord, wordCountMap.getOrDefault(englishWord, 0) + 1);
            }
        }
    }

    public int getWordCount(String word) {
        String englishWord = translator.translate(word);
        return wordCountMap.getOrDefault(englishWord, 0);
    }

    private boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }
}
