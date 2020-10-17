package com.zsz;

import com.zsz.model.ERPSystem;
import com.zsz.raiting.InvalidParametersException;
import com.zsz.raiting.SortingParameters;
import com.zsz.raiting.SystemRanker;
import com.zsz.utils.ExcelReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            SortingParameters.validateUserRequirements();

            final SystemRanker ranker = new SystemRanker(ExcelReader.Reed());

            ranker.sortSystems();
            ranker.printBestResults(15);
        } catch (InvalidParametersException e) {
            System.out.println(e.getMessage());
        }
    }
}
