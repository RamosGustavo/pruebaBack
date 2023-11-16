package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Card;
import com.example.demo.repositories.CardRepository;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }
}
