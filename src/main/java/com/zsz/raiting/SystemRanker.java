package com.zsz.raiting;

import com.sun.jdi.BooleanValue;
import com.zsz.model.ERPSystem;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SystemRanker {
    private List<ERPSystem> systems;

    public SystemRanker(List<ERPSystem> systems) {
        this.systems = systems;
    }

    public void sortSystems(){
        final Comparator<ERPSystem> compareByRatingAndReviews = Comparator.comparing(ERPSystem::getRating)
                .thenComparing(ERPSystem::getReviewCount)
                .reversed();

        systems = systems.stream()
                .filter(this::filterOperatingSystem)
                .filter(this::filterBusinessSize)
                .filter(erpSystem -> erpSystem.getRating() > SortingParameters.getMinimalRating())
                .filter(erpSystem -> erpSystem.getReviewCount() > SortingParameters.getMinimalReviewCount())
                .filter(erpSystem -> erpSystem.getPrice() < SortingParameters.getMaxPrice())
                .sorted(compareByRatingAndReviews)
                .collect(Collectors.toList());
    }

    private Boolean filterOperatingSystem (ERPSystem sys){
        OperatingSystem preferredOS = SortingParameters.getOperatingSystem();

        switch (preferredOS) {
            case MAC:
                return sys.getMac().equals(true);
            case WIN:
                return sys.getWin().equals(true);
            case LINUX:
                return sys.getLin().equals(true);
            default:
                return false;
        }
    }

    private Boolean filterBusinessSize(ERPSystem sys){
        BusinessSize preferredBS = SortingParameters.getBusinessSize();

        switch (preferredBS) {
            case SMALL:
                return sys.getSmall().equals(true);
            case MEDIUM:
                return sys.getMedium().equals(true);
            case LARGE:
                return sys.getLarge().equals(true);
            default:
                return false;
        }
    }

    public void printBestResults(int n){
        int counter = 1;
        for(ERPSystem sys : systems.subList(0, n)) {
            System.out.println(counter++ + ": " + sys.toString());
        }
    }
}
