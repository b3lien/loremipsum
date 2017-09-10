package pl.akademiakodu.loremipsum2;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoremIpsumHome implements LoremIpsum {

    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy" +
            " eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et" +
            " justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";

    private String[] loremIpsumWords;

    private String[] loremIpsumSentences;

    public LoremIpsumHome() {
        this.loremIpsumWords = LOREM_IPSUM.split("\\s");
        this.loremIpsumSentences = LOREM_IPSUM.split("\\.");
    }

    @Override
    public String generateParagraphs(int number) {
        StringBuilder lorem = new StringBuilder();

        for (int i = 0; i < number; i++) {
            lorem.append(LOREM_IPSUM);

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
            if (sentence == 3) {
                lorem.append("\n");
                sentence = 0;
            }
            lorem.append(loremIpsumSentences[sentence] + ".");

        }
        return lorem.toString();
    }

    @Override
    public String generateWords(int number) {
        int word = 0;
        StringBuilder lorem = new StringBuilder();

        for (int i = 0; i < number; i++) {
            if (word == 50) {
                word = 0;
            }

            lorem.append(this.loremIpsumWords[word]);

            if (i < number - 1) {
                lorem.append(' ');
            }

            word++;
        }

        return lorem.toString();
    }

    @Override
    public String toString() {
        return Arrays.toString(loremIpsumWords);
    }

}
