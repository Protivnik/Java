package koschei.models;

import org.springframework.stereotype.Component;

@Component
public class Egg6 {
    private Needle7 needle7;

    public Egg6(Needle7 needle) {
        this.needle7=needle;
    }

    @Override
    public String toString() {
        return ", в яйце иголка " + needle7.toString();
    }
}
