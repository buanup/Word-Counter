package com.wrodcountermicroservice.wordcounter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrodcountermicroservice.wordcounter.service.WordCounterService;

@RestController
@RequestMapping("/word-counter")
public class WordCounterController {

    private final WordCounterService wordCounterService;

    @Autowired
    public WordCounterController(WordCounterService wordCounterService) {
        this.wordCounterService = wordCounterService;
    }

    @PostMapping("/add-words")
    public void addWords(@RequestBody String[] words) {	
        wordCounterService.addWords(words);
    }
    
    @GetMapping("/count/{word}")
    public int getWordCount(@PathVariable String word) {
        return wordCounterService.getWordCount(word);
    }
}
