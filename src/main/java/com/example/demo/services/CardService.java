package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.UpdateBalanceDTO;
import com.example.demo.models.Card;
import com.example.demo.repositories.CardRepository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class CardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card saveCard(Card card) {
        if (isValidCardNumber(card.getCardNumber())) {
            return cardRepository.save(card);
        } else {
            throw new IllegalArgumentException("El número de tarjeta no es válido");
        }
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber.matches("\\d+");
    }

    public Card updateBalance(UpdateBalanceDTO updateBalanceDTO) {
        Card card = cardRepository.findById(updateBalanceDTO.getCardId())
                .orElseThrow(() -> new EntityNotFoundException("Tarjeta no encontrada"));
        card.setBalance(updateBalanceDTO.getNewBalance());
        return cardRepository.save(card);
    }
}
