package com.zsz.raiting;

import java.util.LinkedList;
import java.util.List;

public class SortingParameters {
    private static final Integer MINIMAL_REVIEW_COUNT = 20;
    private static final Double MINIMAL_RATING = 3.0;
    private static final OperatingSystem OPERATING_SYSTEM = OperatingSystem.LINUX;
    private static final BusinessSize BUSINESS_SIZE = BusinessSize.SMALL;
    private static final Integer MAX_PRICE = 2;

    public static void validateUserRequirements() throws InvalidParametersException {
        final List<String> errors = new LinkedList<>();

        if (MINIMAL_REVIEW_COUNT < 0){
            errors.add("MINIMAL_REVIEW_COUNT must be higher than 0");
        }
        if (MINIMAL_RATING < 0 || MINIMAL_RATING > 5){
            errors.add("MINIMAL_RATING must be between 0 and 5");
        }
        if (MAX_PRICE < 0 || MAX_PRICE > 5){
            errors.add("PRICE must be between 0 and 5");
        }

        if (errors.size() > 0){
            final String msg = String.join(", ", errors);

            throw new InvalidParametersException(msg);
        }
    }

    public static Integer getMinimalReviewCount() {
        return MINIMAL_REVIEW_COUNT;
    }

    public static Double getMinimalRating() {
        return MINIMAL_RATING;
    }

    public static OperatingSystem getOperatingSystem() {
        return OPERATING_SYSTEM;
    }

    public static BusinessSize getBusinessSize() {
        return BUSINESS_SIZE;
    }

    public static Integer getMaxPrice() {
        return MAX_PRICE;
    }
}
