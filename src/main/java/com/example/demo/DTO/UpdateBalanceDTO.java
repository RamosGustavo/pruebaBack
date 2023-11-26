package com.example.demo.DTO;

import java.math.BigDecimal;

public class UpdateBalanceDTO {
    private Long cardId;
    private BigDecimal newBalance;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }
}
