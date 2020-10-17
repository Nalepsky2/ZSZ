package com.zsz.raiting.all;

import com.zsz.model.AllERPSystem;
import com.zsz.raiting.Sorter;
import com.zsz.raiting.SortingParameters;
import com.zsz.raiting.SystemRanker;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AllSystemsRanker extends SystemRanker<AllERPSystem> implements Sorter {

    public AllSystemsRanker(List<AllERPSystem> systems) {
        super(systems);
    }

    @Override
    public void sortSystems(){
        final Comparator<AllERPSystem> compareByRatingAndReviews = Comparator.comparing(AllERPSystem::getRating)
                .thenComparing(AllERPSystem::getReviewCount)
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

    private Boolean filterOperatingSystem (AllERPSystem sys){
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

    private Boolean filterBusinessSize(AllERPSystem sys){
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
}
