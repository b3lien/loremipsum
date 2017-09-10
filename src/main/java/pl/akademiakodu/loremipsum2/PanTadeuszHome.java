package pl.akademiakodu.loremipsum2;


import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PanTadeuszHome implements PanTadeusz {

        public static final String PAN_TADEUSZ = "Litwo! Ojczyzno moja! ty jesteś jak zdrowie." +
                "Ile cię trzeba cenić, ten tylko się dowie,Kto cię stracił." +
                " Dziś piękność twą w całej ozdobieWidzę i opisuję, bo tęsknię po tobie." +
                "Panno Święta, co jasnej bronisz CzęstochowyI w Ostrej świecisz Bramie." +
                " Ty, co gród zamkowyNowogródzki ochraniasz z jego wiernym ludem.";

        private String[] panTadeuszWords;

        private String[] panTadeuszSentences;

        public PanTadeuszHome() {
            this.panTadeuszWords = PAN_TADEUSZ.split("\\s");
            this.panTadeuszSentences = PAN_TADEUSZ.split("\\.");
        }

        @Override
        public String generateParagraphs(int number) {
            StringBuilder lorem = new StringBuilder();

            for (int i = 0; i < number; i++) {
                lorem.append(PAN_TADEUSZ);

                if (i < number - 1) {
                    lorem.append("\n");
                }
            }

            return lorem.toString();
        }

        @Override
        public String generateSentences(int number) {
            int sentence = 0;
            StringBuilder lorem = new StringBuilder();

            for (int i = 0; i < number; i++) {
                if (sentence == 5) {
                    lorem.append("\n");
                    sentence = 0;
                }
                lorem.append(panTadeuszSentences[sentence] + ".");

            }
            return lorem.toString();
        }

        @Override
        public String generateWords(int number) {
            int word = 0;
            StringBuilder lorem = new StringBuilder();

            for (int i = 0; i < number; i++) {
                if (word == 46) {
                    word = 0;
                }

                lorem.append(this.panTadeuszWords[word]);

                if (i < number - 1) {
                    lorem.append(' ');
                }

                word++;
            }

            return lorem.toString();
        }

        @Override
        public String toString() {
            return Arrays.toString(panTadeuszWords);
        }

    }
