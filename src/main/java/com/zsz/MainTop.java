package com.zsz;

import com.zsz.raiting.InvalidParametersException;
import com.zsz.raiting.SortingParameters;
import com.zsz.raiting.top.TopSystemsRanker;
import com.zsz.utils.ExcelReader;

public class MainTop {

    public static void main(String[] args) {
        try {
            SortingParameters.validateUserRequirements();

            final TopSystemsRanker ranker = new TopSystemsRanker(ExcelReader.ReedTop());

            ranker.sortSystems();
            ranker.printResults();
        } catch (InvalidParametersException e) {
            System.out.println(e.getMessage());
        }
    }
}
