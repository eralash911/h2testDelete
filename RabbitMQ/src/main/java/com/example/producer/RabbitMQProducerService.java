package com.example.producer;

public interface RabbitMQProducerService {
    void sendMessage(String message, String routingKey);
}
