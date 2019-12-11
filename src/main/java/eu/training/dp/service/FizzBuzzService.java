package eu.training.dp.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    public String getFizzBuzzFor(int upperLimit) {
        if(upperLimit<=0) {
            throw new RuntimeException("Given limit must be a positive number");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= upperLimit; i++) {
            if (i % 3 == 0) result.append("Fizz");
            if (i % 5 == 0) result.append("Buzz");
            else if (i % 3 != 0) result.append(i);
            result.append(", ");
        }
        return result.toString();
    }
}
