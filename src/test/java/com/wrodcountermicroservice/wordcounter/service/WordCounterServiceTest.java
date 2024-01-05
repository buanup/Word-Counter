package com.wrodcountermicroservice.wordcounter.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.wrodcountermicroservice.wordcounter.domain.Translator;

class WordCounterServiceTest {

    @Mock
    private Translator mockTranslator;

    private WordCounterService wordCounterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wordCounterService = new WordCounterService(mockTranslator);
    }

    @Test
    void testAddWords() {
        Mockito.when(mockTranslator.translate("flower")).thenReturn("flower");

        Mockito.when(mockTranslator.translate("apple")).thenReturn("apple");
        Mockito.when(mockTranslator.translate("manzana")).thenReturn("apple");
        
        Mockito.when(mockTranslator.translate("orange")).thenReturn("orange");
        Mockito.when(mockTranslator.translate("Rose")).thenReturn("Rose");

        wordCounterService.addWords("flower", "manzana", "orange");
        wordCounterService.addWords("flower", "blume", "flor");

        assertEquals(2, wordCounterService.getWordCount("flower"));
        assertEquals(1, wordCounterService.getWordCount("apple"));
        assertEquals(1, wordCounterService.getWordCount("orange"));
        assertEquals(0, wordCounterService.getWordCount("Rose"));
    }
}
