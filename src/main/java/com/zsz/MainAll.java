package com.zsz;

import com.zsz.raiting.InvalidParametersException;
import com.zsz.raiting.SortingParameters;
import com.zsz.raiting.all.AllSystemsRanker;
import com.zsz.utils.ExcelReader;

public class MainAll {

    public static void main(String[] args) {
        try {
            SortingParameters.validateUserRequirements();

            final AllSystemsRanker ranker = new AllSystemsRanker(ExcelReader.Reed());

            ranker.sortSystems();
            ranker.printResults(15);
        } catch (InvalidParametersException e) {
            System.out.println(e.getMessage());
        }
    }
}
