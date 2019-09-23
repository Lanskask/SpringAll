package ru.smurtazin.messaging.messaging;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter @Setter
public class Email {
        private String to;
        private String body;
}
