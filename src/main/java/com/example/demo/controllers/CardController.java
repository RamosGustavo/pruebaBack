package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Card;
import com.example.demo.services.CardService;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card savedCard = cardService.saveCard(card);
        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }
}
