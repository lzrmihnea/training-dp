package eu.training.dp.chainofresp;

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
