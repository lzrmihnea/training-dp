package eu.training.dp.s02_fizz_buzz.chainofresp;

public abstract class FizzBuzzBaseHandler {

    private FizzBuzzBaseHandler next;

    public FizzBuzzBaseHandler linkWith(FizzBuzzBaseHandler next) {
        this.next = next;
        return next;
    }

    public abstract String check(int number);

    public String checkNext(int number) {
        if (next == null) {
            return "";
        }
        return next.check(number);
    }
}
