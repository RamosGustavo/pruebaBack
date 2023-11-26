package com.example.demo.DTO;

public class UpdateBalanceDTO {
    private Long cardId;
    private double newBalance;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }
}
